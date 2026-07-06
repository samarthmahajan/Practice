---

# Group Anagrams — Medium
Problem Link: https://leetcode.com/problems/group-anagrams/
Solved Date: 2026-06-24
Pattern Tag: hashing / group-by-canonical-key

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-10
- Last Rating: Strong
- Review Count: 4
- Graduated: No

---

# Real World Analogy
- Sorting mail into pigeonholes by ZIP code: the letter's *contents* don't matter, only its canonical address. Every word computes its "address" (letter-count signature) and drops into the matching pigeonhole.

## Core Insight
Anagrams share exactly one thing — their multiset of letters — so map each word to a **canonical, value-comparable key** derived purely from letter counts; words with the same key are anagrams.

## Approach
For each word, build a 26-slot letter-count signature and turn it into a `String` (so the map compares it by content, not identity). Bucket the word under that key in a `Map<String, List<String>>`. Return the map's values.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Key = letter-count signature, not sort   ║ O(k) to build vs O(k log k) to sort each word        ║
║ Convert count array → String key         ║ raw int[]/char[] use IDENTITY equals/hashCode →      ║
║                                          ║ identical contents would be "different" keys         ║
║ 26 fixed slots, no delimiter needed      ║ each count owns one slot → no [1,11] vs [11,1] clash ║
║ Return map.values()                      ║ groups are exactly the buckets, order irrelevant     ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
map = {}                              // String key -> List<String>
for each word in strs:
    counts = new int/char[26]
    for each ch in word: counts[ch - 'a']++
    key = String.valueOf(counts)      // value-comparable canonical form
    map.computeIfAbsent(key, []).add(word)
return map.values()
```

## Complexity

### Time: O(n · k)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Tally each word       ║ O(k)           ║ scan its k chars                             ║
║ Build key             ║ O(26)=O(1)     ║ fixed-size signature                         ║
║ Total                 ║ O(n · k)       ║ n words; must read every char once           ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n · k)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ Map values       ║ O(n · k) ║ stores all input strings                     ║
║ Keys             ║ O(n)     ║ one 26-char key per group                    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- **THE trap: never use a raw `int[]`/`char[]` as a HashMap key** — it compares by reference, so equal contents won't match. Convert to `String` (`String.valueOf(chars)`) or `Arrays.toString(...)`.
- Empty string is a valid word → forms its own group; a list holding only `""` prints as `[]`.
- If you used a *non-fixed-width* key (e.g. joining int counts), you'd need a delimiter to avoid `1,11` vs `11,1` collisions. The fixed 26-slot design avoids this.
- Sort-the-word key (`new String(sorted)`) also works but is O(k log k) per word — strictly worse.

## Dry Run
strs = ["eat","tea","tan","ate","nat","bat"]
- eat → a1e1t1 = K1 → {K1:[eat]}
- tea → a1e1t1 = K1 → {K1:[eat,tea]}
- tan → a1n1t1 = K2 → {K1:[eat,tea], K2:[tan]}
- ate → a1e1t1 = K1 → {K1:[eat,tea,ate], K2:[tan]}
- nat → a1n1t1 = K2 → {K1:[eat,tea,ate], K2:[tan,nat]}
- bat → a1b1t1 = K3 → {..., K3:[bat]}
- return values → [[eat,tea,ate],[tan,nat],[bat]]

## Boiler Plate Template
Put the standard template boilerplate which can be used for other similar problems as well (group-by-canonical-key):

```java
Map<String, List<String>> map = new HashMap<>();
for (String str : strs) {
    char[] counts = new char[26];
    for (char ch : str.toCharArray()) counts[ch - 'a']++;
    String key = String.valueOf(counts);          // value-comparable canonical key
    map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
}
return new ArrayList<>(map.values());
```

## Solve Log
- 2026-06-24 — `~` assisted (Medium, in time). Pattern recognized cold and unaided; needed a steer that a raw int[] can't be a HashMap key (use a value-comparable String key). Requeued to redo cold 2026-06-27. MAANG 4/5.
