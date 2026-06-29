# Product of Array Except Self — Medium
Problem Link: https://leetcode.com/problems/product-of-array-except-self/
Solved Date: 2026-06-25
Pattern Tag: arrays / prefix-suffix-product

## SRS Tracking
- Stage: 2
- Review Date: 2026-07-01
- Last Rating: Strong
- Review Count: 2
- Graduated: No

---

# Real World Analogy
- A team scoresheet where each player's "adjusted score" is the product of every OTHER player's score. You make one left-to-right pass noting the running product before you, and one right-to-left pass noting the running product after you — then multiply the two.

## Core Insight
`answer[i]` = (product of everything LEFT of i) × (product of everything RIGHT of i). Build prefix and suffix product arrays in two passes, combine in a third. No division needed.

## Approach
Seed `pre[0] = 1` and `suff[n-1] = 1`. Fill `pre[i] = pre[i-1] * nums[i-1]` left to right; fill `suff[i] = suff[i+1] * nums[i+1]` right to left. Final answer: `ans[i] = pre[i] * suff[i]`.

## Mental Model

╔══════════════════════════════════════════╦══════════════════════════════════════════════════════╗
║ Decision                                 ║ Why                                                  ║
╠══════════════════════════════════════════╬══════════════════════════════════════════════════════╣
║ Seed pre[0] = 1, suff[n-1] = 1          ║ No elements to the left of index 0 (or right of n-1) ║
║ pre[i] uses nums[i-1], not nums[i]       ║ We want product EXCLUDING nums[i] itself             ║
║ suff[i] uses nums[i+1], not nums[i]      ║ Same reason — exclude self                           ║
║ Zeros handled naturally                  ║ No special-casing; 0 just propagates through product ║
║ No division operator                     ║ Prefix/suffix avoids needing total product ÷ self    ║
╚══════════════════════════════════════════╩══════════════════════════════════════════════════════╝

## Pseudocode
```
pre[0] = 1
for i = 1 to n-1: pre[i] = pre[i-1] * nums[i-1]

suff[n-1] = 1
for i = n-2 to 0: suff[i] = suff[i+1] * nums[i+1]

for i = 0 to n-1: ans[i] = pre[i] * suff[i]
return ans
```

## Complexity

### Time: O(n)

╔═══════════════════════╦════════════════╦══════════════════════════════════════════════╗
║ Component             ║ Cost           ║ Why                                          ║
╠═══════════════════════╬════════════════╬══════════════════════════════════════════════╣
║ Prefix pass           ║ O(n)           ║ One scan left to right                       ║
║ Suffix pass           ║ O(n)           ║ One scan right to left                       ║
║ Combine pass          ║ O(n)           ║ One scan to multiply pre × suff              ║
║ Total                 ║ O(n)           ║ Three linear passes                          ║
╚═══════════════════════╩════════════════╩══════════════════════════════════════════════╝

### Space: O(n)

╔══════════════════╦══════════╦══════════════════════════════════════════════╗
║ Structure        ║ Size     ║ Why                                          ║
╠══════════════════╬══════════╬══════════════════════════════════════════════╣
║ pre[]            ║ O(n)     ║ One slot per element                         ║
║ suff[]           ║ O(n)     ║ One slot per element                         ║
╚══════════════════╩══════════╩══════════════════════════════════════════════╝

O(1) extra space variant: use ans[] as the prefix array, then do a single right-to-left
pass with a rolling `suffix` variable: `ans[i] *= suffix; suffix *= nums[i]`. Eliminates suff[].

## Watch Out For
- `pre[i] = pre[i-1] * nums[i-1]` — uses `nums[i-1]`, NOT `nums[i]`. Off-by-one here is silent death.
- `suff[i] = suff[i+1] * nums[i+1]` — same: uses `nums[i+1]`, not `nums[i]`.
- Zeros: no special handling needed — the algorithm naturally produces 0 where expected.
- Two-zero input (e.g. [0,0,2,3]): all outputs are 0. Falls out correctly without any if-checks.

## Dry Run
nums = [1, 2, 3, 4]

pre:  [1, 1, 2, 6]    (pre[0]=1, pre[1]=1×1=1, pre[2]=1×2=2, pre[3]=2×3=6)
suff: [24, 12, 4, 1]  (suff[3]=1, suff[2]=1×4=4, suff[1]=4×3=12, suff[0]=12×2=24)
ans:  [24, 12, 8, 6]  ✓

## Boiler Plate Template
Standard prefix-suffix product (O(n) space):

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] pre  = new int[n];
    int[] suff = new int[n];
    pre[0]     = 1;
    suff[n-1]  = 1;
    for (int i = 1;     i < n;  i++) pre[i]  = pre[i-1]  * nums[i-1];
    for (int i = n - 2; i >= 0; i--) suff[i] = suff[i+1] * nums[i+1];
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) ans[i] = pre[i] * suff[i];
    return ans;
}
```

O(1) extra space variant:

```java
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    ans[0] = 1;
    for (int i = 1; i < n; i++) ans[i] = ans[i-1] * nums[i-1];  // ans = prefix
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
        ans[i] *= suffix;
        suffix *= nums[i];
    }
    return ans;
}
```

## Solve Log
- 2026-06-25 — `~` assisted (Medium, in time). One level-1 hint used ("two halves separately"). Identified prefix+suffix independently from hint. Redo cold 2026-06-28. MAANG 3/5.
