# Encode and Decode Strings — Medium
Problem Link: https://leetcode.com/problems/encode-and-decode-strings/
Solved Date: 2026-06-27
Pattern Tag: encoding / length-prefix

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-12
- Last Rating: Strong
- Review Count: 3
- Graduated: No

> 2026-07-05 redo-cold: PASSED per suspension rule (pass = Strong review). 23/30 min, 5/5 first run incl. [""] vs [] distinction. Coach flag on record: narration + dry run + code matched this card verbatim (incl. formatting); Samarth affirmed unaided — accepted as final.

---

# Real World Analogy
- Shipping mixed parcels in one truck with no dividers. Before each parcel you tape a label saying "the next 6 boxes belong to parcel A." The unloader reads the label, counts off exactly 6 boxes, then reads the next label. It never has to guess where one parcel ends — even if a parcel *contains* a box that looks like a label — because it unloads by COUNT, not by looking for a marker.

## Core Insight
No character is safe as a separator (data can contain anything), so don't mark where a string *ends* — declare its **length up front** as `<len>#<payload>`. The decoder reads the length, then consumes exactly that many chars by COUNT, so any `#`/digit inside the payload is just data and can never fool it.

## Approach
Encode each string as its length, a `#` delimiter, then the raw string. To decode, read digits until you hit `#` to get the count `k`, slice the next `k` characters as the payload, then jump the cursor past them to the next length number. Repeat to the end.

## Mental Model

╔══════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                     ║ Why                                                  ║
╠══════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Length prefix, not a separator char          ║ Any char (incl. '#', ',') can appear in data, so no  ║
║                                              ║ separator is safe. A count is content-agnostic.      ║
║ '#' between length and payload               ║ Marks where the NUMBER ends; without it "12abc" is   ║
║                                              ║ ambiguous (len 1? 12?).                              ║
║ Decode by substring + i += digit (COUNT)     ║ Reading k chars by count means inner '#'/digits are  ║
║                                              ║ skipped, never scanned — this is the whole trick.    ║
║ '#' only has meaning while reading the length║ Once count is known, payload is grabbed blindly;     ║
║                                              ║ delimiter logic is OFF during payload.               ║
╚══════════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
encode(strs):
  sb = ""
  for s in strs:
    sb += len(s) + "#" + s
  return sb

decode(str):
  res = []
  i = 0, num = 0
  for i over str:
    if isDigit(str[i]):
      num = num*10 + (str[i] - '0')
    else if str[i] == '#':
      res.add( str.substring(i+1, i+1+num) )   // grab exactly num chars
      i += num                                  // JUMP past payload
      num = 0
  return res
```

## Complexity

### Time: O(N)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Encode                ║ O(N)           ║ Append each char once (N = total chars).      ║
║ Decode                ║ O(N)           ║ Each char read at most once; payload jumped.  ║
║ Total                 ║ O(N)           ║ Linear — must touch every char to transmit.   ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(N)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ Output string/list║ O(N)    ║ Encoded string / decoded list hold all chars. ║
║ Aux working mem  ║ O(1)     ║ Just cursor + running number.                 ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- **Decode must read by COUNT, not by scanning for `#`.** If you scan for the next `#` you break on payloads containing `#`. The `i += digit` jump is non-negotiable.
- **Empty string** round-trips as `0#` → make sure `substring(i+1, i+1+0)` yields `""`, not skipped.
- **Empty list** `[]` encodes to `""`; `decode("")` must return `[]`, not `[""]` (loop simply never runs — good).
- **Length-number parse:** accumulate `num*10 + (c-'0')` for multi-digit lengths (e.g. a 12-char string → `12#...`). Don't assume single digit.
- Use `c - '0'`, not `Integer.parseInt(String.valueOf(c))` — same result, no allocation.

## Dry Run
str = "6#4#neet2#120#"  (from ["4#neet", "12", ""])
- i=0 '6' → num=6
- i=1 '#' → substring(2, 8) = "4#neet"; add; i+=6 → i=7; num=0
  - note: the '#' at index 3 (inside "4#neet") is JUMPED, never scanned ✓
- i=8 '2' → num=2
- i=9 '#' → substring(10, 12) = "12"; add; i+=2 → i=11; num=0
- i=12 '0' → num=0
- i=13 '#' → substring(14,14) = ""; add; i+=0; num=0
- end → ["4#neet", "12", ""] ✅

## Boiler Plate Template
Reusable for any "serialize a list of arbitrary strings into one string and parse it back" (also the backbone of serialize/deserialize-style problems).

```java
// ENCODE: length-prefix each element
public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) sb.append(s.length()).append('#').append(s);
    return sb.toString();
}

// DECODE: read length, then consume that many chars BY COUNT
public List<String> decode(String str) {
    List<String> res = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
        int j = i;
        while (str.charAt(j) != '#') j++;          // j stops at delimiter
        int len = Integer.parseInt(str.substring(i, j));
        String payload = str.substring(j + 1, j + 1 + len);
        res.add(payload);
        i = j + 1 + len;                            // jump past payload
    }
    return res;
}
```
