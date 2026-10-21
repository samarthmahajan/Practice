# SRS Review Index

> **Suspension rule (v3, 2026-07-12):** only a pending **class-A** redo suspends a card — its row shows `SUSP → redo YYYY-MM-DD` in the Review Date column so the morning hook never lists it as due (pass = Strong review from pass date; fail = requeue +3 days, stays suspended; never show a card right before its redo — contamination). **Class-B cards stay LIVE**; their first review prompt is the missed WHY noted at the top of the card.

| File | Problem | Tag | Stage | Review Date | Last Rating | Review Count | Graduated |
|---|---|---|---|---|---|---|---|
| simplify-path-solved.md | Simplify Path | simulation-stack | 5 | 2026-11-16 | Strong | 4 | No |
| evaluate-reverse-polish-notation-solved.md | Evaluate Reverse Polish Notation | expression-parsing | 5 | 2026-11-17 | Strong | 4 | No |
| daily-temperatures-solved.md | Daily Temperatures | monotonic-stack | 5 | 2026-11-05 | Strong | 8 | No |
| asteroid-collision-solved.md | Asteroid Collision | simulation-stack | 4 | 2026-10-25 | Strong | 2 | No |
| next-greater-element-ii-solved.md | Next Greater Element II | monotonic-stack | 4 | 2026-11-04 | Strong | 2 | No |
| next-greater-element-i-solved.md | Next Greater Element I | monotonic-stack | 4 | 2026-10-26 | Strong | 1 | No |
| valid-parentheses-solved.md | Valid Parentheses | matching-stack | 5 | 2026-11-14 | Strong | 2 | No |
| min-stack-solved.md | Min Stack | auxiliary-stack | 4 | 2026-11-01 | Strong | 1 | No |
| prefix-to-postfix-solved.md | Prefix to Postfix | expression-parsing | 4 | 2026-11-03 | Strong | 1 | No |
| decode-string-solved.md | Decode String | simulation-stack | 5 | 2026-11-02 | Strong | 6 | No |
| basic-calculator-ii-solved.md | Basic Calculator II | expression-parsing | 5 | 2026-11-02 | Strong | 4 | No |
| largest-rectangle-in-histogram-solved.md | Largest Rectangle in Histogram | monotonic-stack | 2 | 2026-10-22 | Strong | 6 | No |
| trapping-rain-water-solved.md | Trapping Rain Water | two-pointer / converging-max | 4 | 2026-11-04 | Okay | 3 | No |
| implement-queue-using-stacks-solved.md | Implement Queue using Stacks | stack / amortized-two-stack | 4 | 2026-10-30 | Strong | 3 | No |
| contains-duplicate-solved.md | Contains Duplicate | hashing / set-membership | 5 | 2026-11-14 | Strong | 2 | No |
| valid-anagram-solved.md | Valid Anagram | hashing / frequency-count | 5 | 2026-11-02 | Strong | 4 | No |
| group-anagrams-solved.md | Group Anagrams | hashing / group-by-canonical-key | 4 | 2026-10-29 | Strong | 5 | No |
| top-k-frequent-elements-solved.md | Top K Frequent Elements | bucket-sort / top-k-frequency | 5 | 2026-11-04 | Strong | 3 | No |
| product-of-array-except-self-solved.md | Product of Array Except Self | arrays / prefix-suffix-product | 4 | 2026-10-29 | Strong | 4 | No |
| encode-decode-strings-solved.md | Encode and Decode Strings | encoding / length-prefix | 5 | 2026-11-04 | Strong | 4 | No |
| longest-consecutive-sequence-solved.md | Longest Consecutive Sequence | hashing / set-membership | 4 | 2026-10-29 | Strong | 4 | No |
| valid-palindrome-solved.md | Valid Palindrome | two-pointer / converging-ends | 2 | 2026-10-21 | Okay | 1 | No |
| two-sum-ii-solved.md | Two Sum II - Input Array Is Sorted | two-pointer / converging-ends | 3 | 2026-10-24 | Okay | 3 | No |
| 3sum-solved.md | 3Sum | two-pointer / triplet-dedup | 3 | 2026-10-23 | Strong | 2 | No |
| container-with-most-water-solved.md | Container With Most Water | two-pointer / converging-ends | 2 | 2026-10-22 | Strong | 1 | No |
| best-time-to-buy-and-sell-stock-solved.md | Best Time to Buy and Sell Stock | sliding-window / running-min | 3 | 2026-07-11 | Strong | 2 | No |
| longest-substring-without-repeating-solved.md | Longest Substring Without Repeating Characters | sliding-window / variable-shrink | 2 | 2026-07-08 | Strong | 1 | No |
| longest-repeating-character-replacement-solved.md | Longest Repeating Character Replacement | sliding-window / max-frequency-window | 1 | 2026-07-14 | — | 0 | No |
| permutation-in-string-solved.md | Permutation in String | sliding-window / fixed-window-anagram | 2 | 2026-07-08 | Strong | 1 | No |
| minimum-window-substring-solved.md | Minimum Window Substring | sliding-window / variable-window-cover | 2 | SUSP → redo 2026-07-12 | — | 0 | No |
| sliding-window-maximum-solved.md | Sliding Window Maximum | monotonic-deque / window-max | 1 | SUSP → redo (opens Queues topic) | — | 0 | No |
| binary-search-solved.md | Binary Search | binary-search / standard | 2 | 2026-07-08 | Strong | 1 | No |
| remove-k-digits-solved.md | Remove K Digits | monotonic-stack / remove-k-to-minimize | 3 | 2026-10-27 | Strong | 1 | No |
| search-a-2d-matrix-solved.md | Search a 2D Matrix | binary-search / 2d-matrix-flatten | 1 | 2026-07-14 | — | 0 | No |
| koko-eating-bananas-solved.md | Koko Eating Bananas | binary-search / search-on-answer | 1 | SUSP → redo 2026-10-23 | — | 0 | No |
| remove-duplicate-letters-solved.md | Remove Duplicate Letters | monotonic-stack / lexicographic-smallest-keep-once | 2 | 2026-10-28 | — | 0 | No |
| find-minimum-in-rotated-sorted-array-solved.md | Find Minimum in Rotated Sorted Array | binary-search / rotated-array-find-pivot | 1 | 2026-07-18 | — | 0 | No |
| subarray-sum-equals-k-solved.md | Subarray Sum Equals K | hashing / prefix-sum-frequency | 3 | 2026-10-23 | Strong | 1 | No |
| insert-delete-getrandom-o1-solved.md | Insert Delete GetRandom O(1) | hashing / index-map-swap-remove | 2 | 2026-10-21 | — | 0 | No |
