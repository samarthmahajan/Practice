# Insert Delete GetRandom O(1) — Medium
Problem Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
Solved Date: 2026-10-18
Pattern Tag: hashing / index-map-swap-remove

## SRS Tracking
- Stage: 2
- Review Date: 2026-10-21
- Last Rating: —
- Review Count: 0
- Graduated: No
 
---

# Real World Analogy
- A row of numbered parking spots plus a valet's notebook ("car → spot #"). To pick a random car, roll a die over spot numbers. When a car leaves from the middle, don't shuffle every car down a spot — drive the car from the LAST spot into the empty one and fix that one line in the notebook.

## Core Insight
A list gives uniform random access by index, a map gives O(1) value → index lookup; removing by swapping the victim with the last element makes deletion O(1) because removing from the END of an ArrayList shifts nothing.

## Approach
Keep every value exactly once in a list, and keep a map from value to its current list index. Insert appends and records the index. Remove looks up the index, overwrites that slot with the last element (updating the last element's index in the map), then drops the last slot and the victim's map entry. getRandom picks a uniform index.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Invariant: map.get(list.get(i)) == i     ║ Every op must restore it — it's what makes lookups   ║
║ for every i; each value appears once     ║ and removals O(1) and getRandom correct              ║
║ List alone fails                         ║ Finding a value to remove is O(n)                    ║
║ Map alone fails                          ║ No indexing → no uniform O(1) random pick            ║
║ Swap with last, don't list.remove(index) ║ Middle removal shifts every later element: O(n)      ║
║                                          ║ (and would stale every shifted index in the map)     ║
║ put(last, index) BEFORE map.remove(val)  ║ If val IS the last element, last == val: put is a    ║
║                                          ║ no-op, then remove deletes it. Reversed order puts   ║
║                                          ║ a ghost entry back (val → out-of-bounds index)       ║
║ random.nextInt(list.size())              ║ Each index equally likely + each value at exactly    ║
║                                          ║ one index ⇒ each value has probability 1/n           ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
insert(val):
  if map has val → return false
  map[val] = list.size
  list.add(val)
  return true

remove(val):
  if map lacks val → return false
  index = map[val]
  last  = list[list.size - 1]
  list[index] = last
  map[last]   = index          // must come BEFORE removing val (val may be last)
  list.removeLast()
  map.remove(val)
  return true

getRandom():
  return list[random(0 .. list.size - 1)]
```

## Complexity

### Time: O(1) average per operation

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ map lookup/put/remove ║ O(1) avg       ║ Hashing; worst case degrades with collisions ║
║ list.add (append)     ║ O(1) amortized ║ Occasional resize, amortized over appends    ║
║ list.set / get        ║ O(1)           ║ Array index                                  ║
║ list.remove(last)     ║ O(1)           ║ Nothing after the last slot to shift         ║
║ Total                 ║ O(1) avg       ║ Constant number of the above per call        ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ list             ║ O(n)     ║ One slot per stored value                    ║
║ map              ║ O(n)     ║ One entry per stored value                   ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- Removing the LAST element (last == val): order must be `map.put(last, index)` then `map.remove(val)`. Reversed → ghost entry `val → size` → later remove(val) throws IndexOutOfBounds, later insert(val) wrongly returns false.
- `list.remove(list.size() - 1)` — the `int` overload removes by INDEX. Passing an `Integer` silently calls remove-by-object: O(n) and possibly the wrong element.
- Never `list.remove(index)` from the middle — O(n) shift AND every shifted element's map index goes stale.
- Follow-up (2026-10-18): first answer traced the CORRECT order and called it inconsistent; got it right on a forced trace of the swapped order. Re-test this at review.

## Dry Run 
Start: list = [10, 20, 30], map = {10:0, 20:1, 30:2} → remove(20)

| Step | List | Map |
|---|---|---|
| Before call | [10, 20, 30] | {10:0, 20:1, 30:2} |
| index = map[20] = 1, last = 30 | [10, 20, 30] | {10:0, 20:1, 30:2} |
| list[1] = 30; map[30] = 1 | [10, 30, 30] | {10:0, 20:1, 30:1} |
| remove last slot | [10, 30] | {10:0, 20:1, 30:1} |
| map.remove(20) | [10, 30] | {10:0, 30:1} → return true |

Edge — remove(30) on [10, 20, 30]: index = 2, last = 30 → list[2] = 30 (no-op), map[30] = 2 (no-op) → remove last → [10, 20] → map.remove(30) → {10:0, 20:1}. Consistent.

## Boiler Plate Template
Indexed set: O(1) insert / remove / random pick (also the base for #381 duplicates-allowed: map value → Set of indices).

```java
List<Integer> list = new ArrayList<>();
Map<Integer, Integer> idx = new HashMap<>();   // value -> current index in list
Random random = new Random();

boolean insert(int val) {
    if (idx.containsKey(val)) return false;
    idx.put(val, list.size());
    list.add(val);
    return true;
}

boolean remove(int val) {
    if (!idx.containsKey(val)) return false;
    int i = idx.get(val);
    int last = list.get(list.size() - 1);
    list.set(i, last);                 // move last into the hole
    idx.put(last, i);                  // BEFORE idx.remove(val) — val may be last
    list.remove(list.size() - 1);      // int overload = by index, O(1)
    idx.remove(val);
    return true;
}

int getRandom() {
    return list.get(random.nextInt(list.size()));
}
```
