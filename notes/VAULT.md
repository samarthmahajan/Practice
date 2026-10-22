# Invariant Vault — WHYs produced COLD, in Samarth's own words

The trophy shelf and the highest-ROI pre-mock skim. One line per WHY, dated, only if produced unaided.
Rules: a WHY enters only when produced cold (LOG.md is the evidence). Bounties are NAMED only — never spelled out here; claiming one = producing it cold at the redo/review/drill. Coach adds entries during audits and post-solves; never pre-writes the sentence.

## Claimed (16)
| # | Pattern | WHY (label — his words live in the card/LOG) | Claimed |
|---|---|---|---|
| 1 | sliding-window / running-min | BTBSS — "running min = cheapest buy so far" invariant + O(n)/O(1) | 2026-06-30 |
| 2 | expression-parsing | Basic Calculator II — full invariant + WHY narrated before coding, 5/5 | 2026-07-02 |
| 3 | hashing / group-by-canonical-key | Group Anagrams — "content, not identity" keying, unprompted | 2026-07-05 |
| 4 | binary-search / standard | #704 — `low <= high` DERIVED with volunteered counterexample before coding | 2026-07-06 |
| 5 | monotonic-stack | Daily Temperatures — exact distance line + why the operator flips per direction | 2026-07-06 |
| 6 | sliding-window / fixed-window-anagram | Permutation in String — +out/−in slide produced unaided (closed the 06-29 assisted gap) | 2026-07-06 |
| 7 | sliding-window / max-frequency-window | LRCR — invariant `windowLen − maxCount > k` unprompted (record-mechanism WHY still a bounty) | 2026-07-06 |
| 8 | simulation-stack / builder-expansion | Decode String — time AND space output-sensitive Θ(D), first-try, own words | 2026-07-07 |
| 9 | monotonic-stack / lexicographic-smallest-keep-once | Remove Duplicate Letters — two-part WHY: guard-necessity + lex-dominance, unaided after 3 failed touches | 2026-07-11 |
| 10 | arrays / prefix-suffix-product | Product of Array Except Self — O(1) suffix-fold / scalar-collapse WHY unaided | 2026-07-11 |
| 11 | two-pointer / converging-ends | Two Sum II — elimination WHY produced unaided (closed the 07-05 3-probe gap) | 2026-07-11 |
| 12 | binary-search / rotated-array-find-pivot | Find Minimum — keep/drop asymmetry nailed + fuzz-verified over 20,045 cases | 2026-07-16 |
| 13 | binary-search / search-on-answer | Koko — feasibility is monotonic in k (works at k ⇒ works at any faster k), narrated before coding | 2026-10-16 |
| 14 | hashing / index-map-swap-remove | Insert Delete GetRandom — invariant (value ↔ current index) + why each structure alone fails + why swap-with-last (middle remove shifts O(n)) + 1/n uniformity, all before coding; A&H gate-closing probe | 2026-10-18 |
| 15 | two-pointer / converging-ends | Container With Most Water — short wall already maxed its area at the widest span; keeping it only narrows width, can't raise the cap (first unaided, was coach-supplied 06-28) | 2026-10-22 |
| 16 | sliding-window / variable-window-cover | MWS — have/need O(1) validity: have++ exactly when a char's remaining need hits 0, have-- exactly when it climbs back to 1; incrementing per occurrence falsely validates duplicates (t="AABC"); narrated before coding at the class-A redo | 2026-10-22 |

## Open bounties (5) — name only, no answer text
| Bounty | Pattern | Where it's claimed | Ref |
|---|---|---|---|
| The `< vs <=` keep-branch rule (2 misses in one week) — **half claimed 10-16** (why `<=` with a saved answer); the pairing rule still open | binary-search / boundary-template | Koko redo, Mon 10-19 | GAP-DRILLS.md |
| Rotated-array decisiveness — name the breaking family | binary-search / rotated-array-find-pivot | drill, Tue 08-25 | GAP-DRILLS.md |
| Seam-weld validity WHY | binary-search / 2d-matrix-flatten | drill, Tue 08-25 | GAP-DRILLS.md |
| Failure-direction analysis, one pass | sliding-window / variable-shrink | drill, Fri 08-28 | GAP-DRILLS.md |
| Record-mechanism WHY, one sentence | sliding-window / max-frequency-window | drill, Fri 08-28 | GAP-DRILLS.md |
