# Gap Drills

Open gaps surfaced during review. Muscle = cold-write drill. Conceptual = up to 2 fresh problems.
Purge Closed rows older than 7 days.

| Pattern | Type | Drill | Problem Link | Status |
|---|---|---|---|---|
| monotonic-stack | Muscle | Pop operator RECOVERED (stated `<=` correctly 2026-06-27). Remaining: cold-write the back-to-front method WITHOUT the distance slip — `result[i] = stack.peek() - i`, not `peek()` — and justify on `[73,74]` why `>=` is backwards. | https://leetcode.com/problems/daily-temperatures/ | Closed 2026-07-06 (sprint review: code cold 5/5 incl. [73,74] + plateau; distance line exact; both-direction WHY in own words) |
| simulation-stack / builder-expansion | Muscle | FIRST-TRY complexity for Decode String: state time AND space cold, one shot. Must include: both are output-sensitive Θ(D), input-n is the wrong variable; why a `maxK×` factor over-counts (cost = characters EMITTED — k is already inside the emitted length); bonus: the k=1 nesting re-copy caveat. | https://leetcode.com/problems/decode-string/ | Open (added 2026-07-02) |
| sliding-window / variable-shrink | Muscle | Failure-direction drill: cold-run naive `left = lastSeen[c]+1` (no max) on "abba" index-by-index, ONE pass — name the exact index where left moves backward (i=3, second 'a'), write the 3-char window "bba", and state the direction: window too BIG → OVERcounts (never "undercounts"). Then state in one sentence why Math.max fixes it. | https://leetcode.com/problems/longest-substring-without-repeating-characters/ | Open (added 2026-07-06 — redo passed but analysis took 3 passes) |
| sliding-window / max-frequency-window | Conceptual | Record-mechanism WHY, cold-written in ONE sentence: res only hits a new high when maxCount hits a new REAL high (the only raising line is freq[current] just topping it), and at that instant the window is provably valid — stale windows coast but never set records. ⚠️ Contamination guard: LRCR redo due 07-09 — drill this only right AFTER that attempt, win or lose. | https://leetcode.com/problems/longest-repeating-character-replacement/ | Open (added 2026-07-06 — 2nd redo miss on same sentence) |
