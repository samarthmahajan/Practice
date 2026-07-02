# Gap Drills

Open gaps surfaced during review. Muscle = cold-write drill. Conceptual = up to 2 fresh problems.
Purge Closed rows older than 7 days.

| Pattern | Type | Drill | Problem Link | Status |
|---|---|---|---|---|
| monotonic-stack | Muscle | Derive the pop operator from "pop what can't be the answer." Next strictly-smaller → pop on `>=`; justify on `[2,2,2]` why `>` undercounts. Cold-write the two-pass left/right loops. | https://leetcode.com/problems/largest-rectangle-in-histogram/ | Closed 2026-06-27 (derived `>=` on `[2,2,2]` cold → area 6; boundaries exact) |
| monotonic-stack | Muscle | Pop operator RECOVERED (stated `<=` correctly 2026-06-27). Remaining: cold-write the back-to-front method WITHOUT the distance slip — `result[i] = stack.peek() - i`, not `peek()` — and justify on `[73,74]` why `>=` is backwards. | https://leetcode.com/problems/daily-temperatures/ | Open (added 2026-06-23, narrowed 2026-06-27) |
| simulation-stack / builder-expansion | Muscle | FIRST-TRY complexity for Decode String: state time AND space cold, one shot. Must include: both are output-sensitive Θ(D), input-n is the wrong variable; why a `maxK×` factor over-counts (cost = characters EMITTED — k is already inside the emitted length); bonus: the k=1 nesting re-copy caveat. | https://leetcode.com/problems/decode-string/ | Open (added 2026-07-02) |
