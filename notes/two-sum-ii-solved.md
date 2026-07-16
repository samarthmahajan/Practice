# Two Sum II - Input Array Is Sorted — Medium
Problem Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Solved Date: 2026-06-27
Pattern Tag: two-pointer / converging-ends

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-18
- Last Rating: Strong
- Review Count: 2
- Graduated: No

---

# Real World Analogy
Two people stand at opposite ends of a sorted shelf of weights. They lift the
pair they're holding: too heavy → the person on the heavy (right) end steps in to
a lighter weight; too light → the person on the light (left) end steps up. Because
the shelf is sorted, each step provably can't skip the matching pair.

## Core Insight
Because the array is sorted, the sum at the two ends tells you exactly which
pointer to move: if the sum is too big the largest element can't belong to any
valid pair (every other element is ≤ the current left), so discard it — and
symmetrically for too small. That makes a HashMap unnecessary → O(1) space.

## Approach
Put left at the start, right at the end. Compare numbers[left] + numbers[right]
to target. Equal → return (1-indexed). Too big → right--. Too small → left++.
Exactly one solution is guaranteed, so the pointers will meet it.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Two pointers, NOT a HashMap              ║ Array is sorted + O(1) space asked. Map ignores both. ║
║ sum > target → right--                   ║ numbers[right] is the largest reachable; paired with  ║
║                                          ║ anything ≥ numbers[left] it only gets bigger → drop.  ║
║ sum < target → left++                    ║ numbers[left] is the smallest; it can't reach target  ║
║                                          ║ with anything ≤ numbers[right] → drop it.            ║
║ return {left+1, right+1}                 ║ Problem is 1-indexed.                                 ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
left = 0, right = n - 1
while left < right:
    sum = numbers[left] + numbers[right]
    if sum == target: return [left+1, right+1]
    else if sum > target: right--
    else: left++
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Converging sweep      ║ O(n)           ║ Pointers only move inward; each index once.  ║
║ Total                 ║ O(n)           ║                                              ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(1)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ Two int pointers ║ O(1)     ║ No map; sorted order replaces the lookup.    ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

## Watch Out For
- DON'T default to the #1 Two Sum HashMap — it's O(n) space and ignores "sorted".
  The "sorted" keyword is the whole reason this is a separate problem.
- 1-indexed output: return left+1, right+1 (the #1 mistake).
- Negatives are fine; the sorted comparison logic doesn't care about sign.
- left < right (strict): never reuse the same element twice.

## Dry Run
numbers = [2, 7, 11, 15], target = 9
  left=0(2), right=3(15): 17 > 9 → right-- → 2
  left=0(2), right=2(11): 13 > 9 → right-- → 1
  left=0(2), right=1(7) : 9 == 9 → return [1, 2]  ✓

numbers = [-1, 0], target = -1
  left=0(-1), right=1(0): -1 == -1 → return [1, 2]  ✓

## Boiler Plate Template
Converging two pointers on a sorted array, comparison-driven move:

```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target)      return new int[]{left + 1, right + 1};
        else if (sum > target)  right--;
        else                    left++;
    }
    return new int[]{-1, -1};
}
```
