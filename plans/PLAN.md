# DSA Mastery Plan — Samarth

Goal: by the end, walk into ANY DS&Algo round with an earned ~90% expected pass rate.
DSA only (LLD / system design / behavioral deliberately out of scope).

## The honest contract
- No plan guarantees 90–95% on a single round — variance is real (an unfamiliar hard, nerves).
- What earns the confidence is the EXIT CRITERIA below. "Done with the course" = those gates are green, NOT "finished the list."
- If you fudge "cold-solve" or skip mocks, the number is fiction. The rules are the plan.

## Timeline decision (OPEN — decide by 2026-07-12, after the calibration mock)
Start was 2026-06-21 → Week 11 ends ~**2026-09-05**, and the exit criteria (3 consecutive green blind-set weeks, 8 human mocks) cannot all be green before Week 11–12 **even with zero slips**. The old "~2 months" target contradicts this plan — resolve it deliberately, don't discover it in Week 9.
- **Recommended:** target interviews **≥ 2026-09-07** and tell recruiters mid-September. Costs nothing now, buys the slack the plan currently lacks.
- **If August is immovable:** pre-decided cuts = compress Bit Manipulation, shrink Tries. **Never cut DP or mocks.**
- Lead-level loops also weight system design / LLD (deliberately out of scope here) — September needs reserved bandwidth for it either way.
- **2026-07-02 update:** HLD track added — `plans/HLD-PLAN.md` is now the single source of truth for interview pipeline staging (outreach → screens → onsites) AND for DSA maintenance after Sep 7 (daily SRS + 3 timed problems/wk + Saturday blind sets through the last onsite). Pipeline dates live THERE only. Decide-by unchanged: 2026-07-12 (company list also gates an LLD mini-track — see HLD-PLAN).

---

## Definition of SOLVED (this is the whole game)
A problem counts as SOLVED only if ALL hold:
1. **Unaided** — no hint, no `hint hint`, no pattern name from the coach, no peeking at the solution.
2. **In time box** — Easy ≤15 min · Medium ≤30 min · Hard ≤45 min.
3. **Narrated** — you stated the **governing invariant and WHY it holds** (e.g. "pop on `<=` because cooler-or-equal can never be the answer") out loud / in writing before coding (interview sim). This is the step you skip and the points you lose — enforce it.
4. **Clean + optimal Big-O**, edge cases handled, runs against the test harness.

If you used a hint, ran over time, or saw the answer → it's **NOT solved**. Mark it `~` (assisted) and it goes back in the queue to **redo cold in 3 days**. Only a later unaided pass flips it to `[x]`.

## Per-pattern MASTERY GATE
A pattern is "owned" when: you cold-solve a *fresh* medium of that pattern, in time, **2 of your last 3 attempts**. Don't advance a pattern's weight until its gate is met. Track gate status in each section below.

## Weekly BLIND SET (every Saturday — your real readiness signal)
- 4 problems drawn at RANDOM across ALL patterns learned so far. Timed. No hints. Narrated. Graded by `/mock`.
- Record the cold-solve rate. This number, trending up, is the only metric that matters.

## Reviews & recall
- Daily: `/review-dsa` (SRS) for spaced repetition of solved cards. **Capacity: up to 5/day weekdays, up to 15/day weekends while a backlog exists** (Blitz/Snippet modes preferred — without weekend catch-up capacity the queue mathematically never clears).
- **Queue-dedupe rule (added 2026-07-02):** a problem with a pending redo-cold is **SUSPENDED from SRS review** — the redo supersedes it. A passed redo counts as a Strong review (reschedule from the pass date); a failed redo requeues +3 days and keeps the card suspended. This kills double-billing AND protects cold-test validity — seeing a card's pseudocode hours before its redo-cold would contaminate the "cold."
- Recall drill (daily — kept SMALL so it actually runs): **5 minutes, ≤2 patterns**, cold-write "trigger words → pattern → **the governing invariant + WHY, DERIVED from first principles, not memorized**" into GAP-DRILLS.md. **Contamination guard:** never drill a pattern whose redo-cold is due within 2 days — drill it right AFTER that redo attempt instead (win or lose; post-attempt is when encoding sticks). Interviews are won at recognition speed *and* invariant precision — see **## Your failure mode** below.

## Your failure mode (precision, not recognition)
Diagnosis from real attempts: your pattern **recognition is fine** — you name the right pattern fast. You lose points on the **precise governing invariant**: the exact operator (`>=` vs `>`), the exact guard (`if (output.isEmpty())`), the boundary *why*. So far every miss has been an invariant, never a misread pattern.
- **The cure is derivation, not volume.** For each pattern, be able to *derive* its rule from "what can never be the answer / boundary?" — never memorize the symbol.
- **Highest-ROI review material = each card's "Watch Out For" + the invariant's WHY.** Re-read these, not new problems, when time is short.
- The gap-drill (cold-write the rule + its justification) is the medicine — run it whenever a pattern logs a Weak.

## Mocks
- **From Week 3:** one **calibration** human mock in Week 3, then **1 human mock/week from Week 5** (Pramp / interviewing.io / peer). The coach can't reproduce pressure or follow-ups — get an external read before banking a month of self-grading.
- `/mock` (AI) any time for timed, no-hint, graded reps between human mocks.
- **Blind set #1: Sat 2026-07-04**, mid-sprint, no excuses — it's a measurement, not a reward. Expect a humbling baseline; take it anyway. Every skipped Saturday is a missing data point the exit criteria need (the first one, 2026-06-27, was skipped for new problems — never again).
- **Calibration human mock: BOOK NOW (2026-07-02)** for the Jul 6–12 window — Pramp / interviewing.io have lead times.

## Capacity
≤4 problems/weekday (9–5 job), heavier weekends. ~25–35/week. Quality (cold + narrated) over raw count.

## When the day overflows (triage rule)
When due-reviews + redo-colds + planned-new exceed the day's capacity, drop in this order:
1. **New problems first** — carry them forward.
2. Then Stage 3+ SRS reviews.
3. **Never** drop a redo-cold or a Stage-1 sprint — those are mastery-critical.
Carry dropped *new* problems; never carry dropped *redos*.

## WIP limit (standing rule — added 2026-07-02, the one-sentence fix for Weeks 1–2)
- **No new problem while more than 3 redo-colds are DUE** (redo date ≤ today). Due redos always outrank new work.
- **No new TOPIC while any redo-cold from earlier topics is due**, or while the previous topic's gate has never been attempted.
- The rule counts **due** redos, not pending ones — a fresh `~` schedules its redo +3 days out and must not block tomorrow's work. Deadlock-proof: due redos are always playable, and clearing them unblocks everything.

---

## North-star metric (what `/status` leads with)
- **PRIMARY — blind-set cold-solve rate** (Saturday `/mock`, random, no-hint): your true readiness signal. Target ≥85%, 3 weeks running.
- **SECONDARY — new-problem cold rate** (rolling 2 weeks): a process check, NOT a verdict. It looks ugly early because it includes first-contact hards — watch the *trend*, never panic at the *level*.
- Problem count is a guardrail, not the goal. If the rate isn't climbing, more volume won't help — slow down and fix the invariant.

## EXIT CRITERIA — the 90% gate (all must be green)
- [ ] Every pattern below at its MASTERY GATE.
- [ ] Blind-set cold-solve rate ≥85% for **3 consecutive weeks**.
- [ ] ≥8 human mocks done; last 5 with a "would advance" verdict.
- [ ] DP specifically: cold-solve a fresh medium DP in ≤30 min (the make-or-break topic).
- [ ] ~250–330 problems attempted, ≥60% logged as fully cold `[x]`.

When these are green, the confidence is real. Not before.

---

## 11-Week Schedule
Backbone = the NeetCode-150 set (the proven minimal-complete coverage for tier-one). Each new pattern: conceptual dive (Concept / When to use / How to identify) FIRST, then the curated ladder ranked by PATTERN difficulty.

| Week | Focus |
|---|---|
| 1 (now) | **Stacks** — finish Tier D–F + queue bridge |
| 2 | **Arrays & Hashing** → **Two Pointers** (foundations skipped earlier — fast but mandatory) |
| 3 | **Sliding Window** → **Binary Search** · 1 calibration human mock |
| 4 | **Queues & Deques** → **Linked Lists** |
| 5 | **Trees** (traversals, BST) → **Tries** · weekly human mocks begin |
| 6 | **Heaps / Priority Queue** → **Backtracking** · +1 spaced 1D-DP rep |
| 7 | **Graphs** (BFS/DFS, topo, union-find, shortest path) · +1 spaced DP rep |
| 8 | **Greedy & Intervals** → start **DP** |
| 9 | **DP I** (1D, knapsack, decision) |
| 10 | **DP II** (2D/grid, strings: LCS/edit distance, intervals) + **Bit Manipulation** |
| 11 | **Pure mocks + weak-spot revision** — blind sets daily, human mocks, redo every `~` |

DP gets ~2.5 weeks (8–10). Protect it — don't let earlier topics bleed into it. **Seed it early: 1 spaced 1D-DP rep/week from Week 6** (once recursion matures post-Trees/Backtracking), so Week 8 is *deepening*, not first contact.

*Adjustment 2026-07-02: coverage ran ~1 week ahead (Sliding Window + Binary Search opened in Week 2) while 21 redo-colds piled up and 0/5 touched gates closed. Week 2 therefore ends with a **consolidation sprint (Jul 2–5)** — see CURRENT POSITION — and Week 3 resumes exactly on the written schedule: gate attempts + Binary Search ladder + calibration mock. The sprint costs zero calendar time; it spends the coverage lead to bank the ownership.*

---

## CURRENT POSITION
- **Topic:** 🔓 **CONSOLIDATION SPRINT EXITED 2026-07-06** (rule was: zero new problems until ≤3 redo-colds due; PiS clearing brought it to exactly 3 — MWS, SWM, Binary Search #704 — which still play before any new problem). Coverage ran a week ahead (A&H, Two Pointers, Sliding Window fully attempted; Binary Search opened) but 0 of 5 touched gates are met and 21 redo-colds are pending — the sprint spends the coverage lead to bank the ownership. Stacks gate stays open until its redo-colds pass cold.
- **Sprint schedule (oldest debt first — most decay = truest cold test):**
  - Thu 07-02 (tonight): ✅ Decode String (4/5) · ✅ Basic Calculator II (5/5) · ✅ Remove K Digits (4/5) — 3/3 DONE
  - Fri 07-03: Remove Duplicate Letters · Largest Rectangle in Histogram · Implement Queue using Stacks · Binary Search #704
  - Sat 07-04: **BLIND SET #1 first**, then Valid Anagram · Group Anagrams · Top K Frequent · Product of Array Except Self
  - Sun 07-05: Encode/Decode Strings · Longest Consecutive Sequence · Two Sum II · 3Sum · Container With Most Water · Longest Substring w/o Repeating · LRCR · Permutation in String · Min Window Substring · Sliding Window Maximum
  - Overflow rolls to Mon 07-06 — the new-problem lock holds until ≤3 due. A failed redo requeues +3 days; that's the system working, not a setback.
- **SRS during sprint (suspension rule applied):** only 10 cards are live — Simplify Path, Evaluate RPN, Daily Temperatures, NGE-II, Min Stack, Prefix→Postfix, Contains Duplicate, Valid Palindrome, Trapping Rain Water, Best Time Buy/Sell. The other 18 due cards ride on their redo-colds.
- **Redo cold (2026-07-08):** Remove Duplicate Letters (Tier E) — redo FAILED 2026-07-04/05 (`~` again, 3rd touch): mechanics now cold (skip-before-pop ordering, both pop conditions, boolean un-mark all his; code first-run green 2/2) but over the 30-min box, took help, and the two-part WHY (earlier-smaller-always-wins + evicting-a-never-reappearing-letter loses it forever) still not produced unaided. Gap is pure invariant-justification, not mechanics.
- **[x] CLEARED (2026-07-05):** Largest Rectangle in Histogram (Tier F) — redo passed COLD, in the 45-min Hard box, 4/5. NSL/NSR two-pass his end-to-end: `>=` pop operator + `[2,2]` boundary values produced unaided, first-run green 10/10 incl. zero-split `[4,2,0,3,2,5]`. Ding: dry-ran the output arrays, stack-level mechanics needed prompting. SRS: Stage 2→3, next review 2026-07-10.
- **[x] CLEARED (2026-07-05):** Implement Queue using Stacks (Bridge) — redo passed COLD, in the 15-min box, 4/5. Guard (`if (output.isEmpty())`) + WHY led the narration unprompted; amortized O(1) argument interview-grade; 6/6 first run incl. interleaved push-after-drain. Ding: skipped the requested dry run (2nd occurrence this sprint). SRS: Stage 3→4, next review 2026-07-20.
- **[x] CLEARED (2026-07-05):** Valid Anagram — redo passed COLD, in-time, 4/5. Length guard + per-string loop bounds unaided (the 06-24 off-by-one is dead); 7/7 incl. unequal-length both directions. Dings: volunteered dry-run case was same-length (missed the historical killer), didn't add the requested edge test to main, Unicode follow-up left unanswered. SRS: Stage 2→3, next review 2026-07-10.
- **[x] CLEARED (2026-07-05):** Group Anagrams — redo passed COLD, in-time, 4/5. Canonical-key precision owned: narrated "content not identity" unprompted (the 06-24 int[] lesson), volunteered a correct full dry run, then coded the sharper fixed-26 `String.valueOf(char[26])` key; 3/3 first run. Ding: post-hoc ownership probe on the char[26] key answered with a bare "yes" — the WHY-articulation habit still thin.
- **[x] CLEARED (2026-07-05):** Top K Frequent Elements — redo passed COLD, in-time (self-reported), 4/5. Bucket-by-frequency reached unaided (the 06-24 selection-recognition gap closed); dry run exact; 6/6 first run incl. negatives. Flags on record: dry run came only when demanded; WHY sentence arrived LaTeX-formatted — coach challenged it as pasted, Samarth affirmed it as his, accepted as final; time answer took four asks. Honesty-friction pattern worth watching. SRS: Stage 2→3, next review 2026-07-10.
- **Redo cold (2026-07-08):** Product of Array Except Self — redo `~` again 2026-07-05 (2nd touch): core prefix/suffix approach now COLD (narrated + exact dry run + 23 min, the 06-25 gap closed) but took help mid-attempt for the O(1)-space single-suffix-scalar fold and submitted that aided version; 7/7 green. Honestly self-reported unprompted. Remaining gap: the "second array collapses to a scalar — read once, immediately" idea. Redo should be quick.
- **[x] CLEARED (2026-07-05):** Encode/Decode Strings — redo passed, 23/30 min, 4/5. Approach + invariant + dry run + code all before coach input; 5/5 first run incl. [""] vs [] distinction (verified by size probe). Dings: complexity stated without defining n (= total chars); code used parseInt-substring while narration described digit-accumulation. **Flag on record (honesty-friction, 2nd hard occurrence after Top K 07-05):** narration, dry run, and code matched the suspended card VERBATIM incl. formatting artifacts; coach challenged, Samarth affirmed unaided; accepted as final per Top K precedent. SRS: Stage 1→2, next review 2026-07-07.
- **[x] CLEARED (2026-07-05):** Longest Consecutive Sequence — redo passed COLD, 20/30 min, 4/5. Run-top boundary test + set-iteration (the 06-27 O(n²) fix) narrated + dry-run before code; 5/5 first run incl. duplicates and empty. O(n) WHY (≤2n amortized, each run walked once from its unique top) produced in his own words, though only after one prompt. Dings: WHY needed asking; approach narration arrived LaTeX-formatted (flagged — 3rd formatting tell); told coach to "ignore the flags" — declined, flags stay. SRS: Stage 1→2, next review 2026-07-07.
- **Redo cold (2026-07-08):** Two Sum II (sorted) — redo `~` again 2026-07-05 (2nd touch): recognition NOW COLD (went straight to sorted + two-pointer, no HashMap reflex — the 06-27 gap closed); code cold, optimal, 5/5 first run. But the elimination WHY ("right's best remaining partner is current left → every pair with right overshoots → right can never be in the answer") not produced across three probes — only the "want a smaller sum" heuristic; final probe declined for code review. Same standard as Container 06-28. Remaining gap is one sentence of invariant-justification; coach supplied the derivation post-attempt. Gap-drill this pattern TODAY (post-attempt = when encoding sticks).
- **[x] CLEARED (2026-07-06):** 3Sum — redo passed COLD, 25/30 min, 4/5. Both 06-27 bugs dead: 3-spot dedup + both-pointer advance unaided; 5/5 first run incl. dup-heavy inputs. Narrated both WHYs (pointer-elimination + dedup-safety) in own words BEFORE coding — though only after coach demanded the WHY half. Dry run delivered on first ask (habit improving) but compressed. **Flag on record (5th occurrence):** submitted code matched the suspended card's boilerplate character-for-character incl. comment strings; challenged, Samarth affirmed unaided; accepted per precedent. Mitigating: WHY narration was NOT card text. SRS: Stage 2→3, next review 2026-07-11. **7 redo-colds remain due** (Container, Longest Substring, LRCR, PiS, MWS, SWM, Binary Search) — new-problem lock still ON.
- **[x] CLEARED (2026-07-06):** Container With Most Water — redo passed COLD, 10/30 min, 4/5. The one missing sentence from 06-28 produced: elimination WHY ("any pair keeping the shorter wall has ≤ width AND height still capped by it → can't beat the area already recorded") in own words, though after one probe (move-rule + improvement-claim were unprompted). 5/5 first run incl. tie case; complexity upfront unprompted; dry run exact on first ask incl. stop condition. Code style (`var`) visibly his own. SRS: Stage 1→2, next review 2026-07-08. **6 redo-colds remain due** — lock still ON.
- **[x] CLEARED (2026-06-30):** Best Time to Buy/Sell Stock — redo cold passed Strong. Invariant ("i = running min / cheapest buy so far") + WHY ("a lower buy dominates every future sell, so older higher buys can never win") + O(n)/O(1) all produced unaided.
- **[x] CLEARED (2026-07-02):** Decode String — redo passed cold, 19/30 min, 4/5. Approach + code + two-stack invariant all unaided, first-run green; caught the coach's wrong expected output. Dings: narrated AFTER coding (chronic — 2nd occurrence), and first complexity answer was input-O(n); self-corrected to output-sensitive after one counterexample probe. Gap-drill queued: first-try output-sensitive complexity.
- **[x] CLEARED (2026-07-02):** Basic Calculator II — redo passed cold, 19/30 min, **5/5**. Narrated invariant + WHY + dry run BEFORE coding (habit fixed same night it was called out); complexity O(n)/O(n) stated first-try upfront; first-run green on 9/9 including hidden edges (minus-division truncation 14-3/2=13, single number, negative intermediates). Elegant in-loop end-flush via `i==length-1`. Known follow-up parked: O(1)-space stack-free variant.
- **[x] CLEARED (2026-07-02):** Remove K Digits — redo passed cold, ~24/30 min, 4/5. Rule (strict `>`), code, and all edges unaided — 9/9 first run incl. "1519" k=1 → "119", which disproves the "remove the global largest" rationale he narrated (his CODE implemented the correct leftmost-descent rule; the verbal WHY was the imprecise part). Dings: skipped the requested dry run under time pressure; WHY needed prompting again. Card created (was card-less) → remove-k-digits-solved.md, Stage 2, review 2026-07-05.
- **[x] CLEARED (2026-07-06):** Longest Substring Without Repeating — redo passed COLD, 20/30 min, **3/5**. Code the strongest part: jump-variant (int[128] last-seen + Math.max guard) unaided, 6/6 first run incl. "abba"/"dvdf", O(n)/O(1) stated clean. Dings (all invariant-precision): failure-direction analysis of the naive rule took THREE passes — claimed "undercounts" (backwards), pinned it on the wrong index, filled the coach's dry-run table with a 3-char window written as "ba" and marked valid, only corrected after cell-level pointing; time-taken needed a 2nd ask. Core WHY (backward left re-includes evicted chars) was his. Gap-drill added. SRS: Stage 1→2, next review 2026-07-08. **5 redo-colds remain due** — lock still ON.
- **Redo cold (2026-07-09):** Longest Repeating Character Replacement — redo `~` again 2026-07-06 (2nd touch): big progress — invariant `windowLen−maxCount>k` unprompted (06-29's scaffolding gap closed), code fully cold 6/6 first run in 20/30 min, stale-max DIRECTION argument (over-estimate → relaxed shrink only) his own. But the record-mechanism WHY — "res only hits a new high when maxCount hits a new REAL high, at which instant the window is provably valid" — not produced across 3 probes; two of three asks also ignored mid-thread (complexity/time answered only on 3rd ask). Coach supplied derivation post-attempt. Remaining gap: one sentence, same as 06-29.
- **Redo cold (2026-07-02):** Permutation in String — `~` 2026-06-29 (core idea his — fixed window + freq match; but incremental +out/−in slide and the Java mechanic were coach-supplied, not produced cold).
- **Redo cold (2026-07-09):** Minimum Window Substring (hard) — `~` 2026-06-29; redo-cold attempt 2026-07-06 aborted at the gate: `hint hint hint` requested BEFORE starting (pattern name + have/need template revealed), then declined to attempt the mechanics rep. Cold test contaminated → `~` stands, requeued +3 days. Watch: the have/need O(1) validity check has now been coach-surfaced twice (06-29, 07-06) and never produced unaided.
- **Redo cold (DEFERRED 2026-07-06 → Queues & Deques week, Week 4):** Sliding Window Maximum (hard, deque) — saw solution 2026-06-29 via `code` (full hint ladder → solution). Was due 07-02; Samarth deliberately deferred the redo to the Queues & Deques topic opening (it's already first ⬜ on that ladder next to Implement Queue using Stacks, and the monotonic-deque conceptual dive lands there). Trade-off accepted on record: pattern stays unproduced-cold for ~2 more weeks; card stays SUSPENDED from SRS; the topic must OPEN with this redo before any new deque problem. It is a deviation from "never drop a redo-cold" — deliberate, not silent.
- **[x] CLEARED (2026-07-06):** Binary Search (#704) — redo passed COLD, 5/15 min, **5/5**. The one missing operator now owned at derivation level: narrated "loop while window [low,high] non-empty ⇔ low <= high; at low==high one never-compared cell remains, so the loop MUST run on it" + volunteered the `[2,5]` target-5 dry run that exposes the `<` bug + complexity — ALL before coding, unprompted. 8/8 first run incl. single-cell and two-cell traps; overflow-safe mid; zero symptom-patching. Cleanest redo of the sprint. SRS: Stage 1→2, next review 2026-07-08. **ZERO redo-colds now due — today's due pile fully cleared** (next wave: 07-08 ×3, 07-09 ×2; SWM deferred to Week 4 by deliberate call).
- **[x] CLEARED (2026-07-06):** Permutation in String — redo passed COLD, 20/30 min, 4/5, 6/6 first run. The 06-29 assisted gap (incremental +out/−in slide) produced unaided in narration AND code; s1>s2 guard, first-window check, and the subtle `left+win < len` loop boundary all his; caught nothing wrong himself but code disproved a wrong expected-value in the coach's stub (2nd such catch this sprint). Dry run before coding, delivered compressed on first ask. Ding: `Arrays.stream().allMatch` per slide (card's Watch Out For explicitly says plain loop / matches counter) — O(26) so complexity fine, polish gap only. SRS: Stage 1→2, next review 2026-07-08. **3 redo-colds remain due (Min Window Substring, Sliding Window Maximum, Binary Search #704) — SPRINT EXIT CONDITION MET (≤3 due), new-problem lock LIFTED.** Due redos still outrank new problems (Daily Rhythm #2). *(Later 07-06: MWS hint-contaminated pre-attempt → requeued 07-09; 2 remain due today — SWM, Binary Search #704.)*
- **Next new problem (🔓 unlocked 2026-07-06, but 3 due redos play first):** Search a 2D Matrix (Binary Search ladder; conceptual dive already done).

---

## Curated ladders (✅=cold-solved, ~=assisted/redo, ⬜=todo)

### Stacks  — gate: monotonic + simulation cold medium
Tier A · ✅ Next Greater Element II · ✅ Daily Temperatures
Tier B · ✅ Asteroid Collision · ✅ Simplify Path
Tier C · ✅ Evaluate RPN · ✅ Decode String (redo passed COLD 2026-07-02 — 19/30 min, 4/5, unaided; caught coach's wrong expected output; complexity needed one pushback, then self-corrected to output-sensitive)
Tier D · ✅ Basic Calculator II (redo passed COLD 2026-07-02 — 19/30 min, 5/5: narrated first, complexity first-try, 9/9 incl. hidden edges)
Tier E · ✅ Remove K Digits (redo passed COLD 2026-07-02 — ~24/30 min, 4/5, 9/9 incl. hidden "1519" trap) · ~ Remove Duplicate Letters (assisted 2026-06-22; redo FAILED 2026-07-04/05 — over time + help, WHY not cold; mechanics were — redo cold 2026-07-08)
Tier F · ✅ Largest Rectangle in Histogram (redo passed COLD 2026-07-05 — in-time Hard, 4/5, 10/10 incl. edges; `>=` operator + sentinels unaided) · ✅ Trapping Rain Water (cold 2026-06-23, 4/5)
Bridge · ✅ Implement Queue using Stacks (redo passed COLD 2026-07-05 — in-time, 4/5, 6/6; guard + amortized argument unaided)
(Earlier: ✅ Valid Parentheses · ✅ Min Stack · ✅ Prefix→Postfix · ✅ NGE-I)

### Arrays & Hashing — gate: hashing-for-O(1)-lookup cold medium
✅ Two Sum · ✅ Contains Duplicate (cold 2026-06-23, 5/5) · ✅ Valid Anagram (redo passed COLD 2026-07-05 — in-time, 4/5, 7/7 incl. unequal lengths) · ✅ Group Anagrams (redo passed COLD 2026-07-05 — in-time, 4/5, 3/3; canonical-key + dry run unaided) · ✅ Top K Frequent Elements (redo passed COLD 2026-07-05 — in-time self-reported, 4/5, 6/6; bucket-by-frequency unaided) · ~ Product of Array Except Self (assisted 2026-06-25; redo `~` 2026-07-05 — core cold, O(1)-space fold aided, honestly reported — redo cold 2026-07-08) · ✅ Encode/Decode Strings (redo passed 2026-07-05 — 23/30 min, 4/5, 5/5 first run; verbatim-card-match flag on record) · ✅ Longest Consecutive Sequence (redo passed COLD 2026-07-05 — 20/30 min, 4/5, 5/5 first run; set-iteration fix owned)

### Two Pointers — gate: converging/opposite-ends cold medium
✅ Valid Palindrome (cold 2026-06-27, 4/5) · ~ Two Sum II (sorted) (redo `~` 2026-07-05 — recognition + code now cold, 5/5 first run; elimination WHY not produced in 3 probes — redo cold 2026-07-08) · ✅ 3Sum (redo passed COLD 2026-07-06 — 25/30 min, 4/5, 5/5 first run incl. dup-heavy; 3-spot dedup + both-pointer advance unaided; verbatim-card flag on record) · ✅ Container With Most Water (redo passed COLD 2026-07-06 — 10/30 min, 4/5, 5/5 first run; elimination WHY produced in own words after one probe)

### Sliding Window — gate: variable window + shrink condition cold medium
~ Best Time to Buy/Sell Stock (assisted 2026-06-28, first invariant wrong "increment both", fixed via coach counterexample; WHY "left=running min" coach-supplied; steps scaffolded — redo cold 2026-07-01) · ✅ Longest Substring Without Repeating (redo passed COLD 2026-07-06 — 20/30 min, 3/5, 6/6 first run with jump-variant; naive-rule failure analysis took 3 passes — gap-drill open) · ~ Longest Repeating Character Replacement (redo `~` again 2026-07-06 — code + invariant now cold 6/6, stale-max direction his; record-mechanism WHY still not produced in 3 probes — redo cold 2026-07-09) · ✅ Permutation in String (redo passed COLD 2026-07-06 — 20/30 min, 4/5, 6/6 first run; incremental +out/−in slide + guard + first-window check all unaided — the 06-29 gap closed; ding: stream-allMatch per slide again, plain-loop/matches-counter polish still not internalized) · ~ Minimum Window Substring (hard) (assisted 2026-06-29, 4/5 — approach his & correct on a Hard incl. shrink-stop; but coach pre-pointed the 2 precision spots and validity check was per-step scan not have/need → not clean-optimal; 07-06 redo aborted after pre-attempt hint-hint-hint — redo cold 2026-07-09) · ~ Sliding Window Maximum (deque) (saw solution 2026-06-29 via `code` — used full hint ladder then asked for the solution; monotonic-deque pattern new to him — redo DEFERRED 2026-07-06 to Queues & Deques week; that topic opens with it)

### Binary Search — gate: "search on the answer" cold medium
✅ Binary Search (redo passed COLD 2026-07-06 — 5/15 min, **5/5**: the `low <= high` invariant DERIVED unaided ("window [low,high] non-empty; at low==high one never-compared cell remains") with the `[2,5]`-target-5 counterexample volunteered BEFORE coding; 8/8 first run; no symptom patches) · ⬜ Search a 2D Matrix · ⬜ Koko Eating Bananas · ⬜ Find Minimum in Rotated Sorted Array · ⬜ Search in Rotated Sorted Array · ⬜ Median of Two Sorted Arrays (hard)

### Queues & Deques — gate: monotonic deque cold medium
✅ Implement Queue using Stacks (already cleared via Stacks bridge 2026-07-05) · ⬜ **Sliding Window Maximum — MUST OPEN THE TOPIC as a redo-cold** (deferred from 07-02, saw solution 06-29; no new deque problem before it) · ⬜ Number of Recent Calls · ⬜ Design Circular Queue

### Linked Lists — gate: pointer-rewiring + fast/slow cold medium
⬜ Reverse Linked List · ⬜ Merge Two Sorted Lists · ⬜ Linked List Cycle · ⬜ Reorder List · ⬜ Remove Nth Node From End · ⬜ Copy List With Random Pointer · ⬜ Add Two Numbers · ⬜ LRU Cache · ⬜ Merge K Sorted Lists (heap)

### Trees — gate: DFS recursion + BFS level-order cold medium
⬜ Invert Binary Tree · ⬜ Max Depth · ⬜ Diameter · ⬜ Balanced Binary Tree · ⬜ Same Tree · ⬜ Subtree of Another Tree · ⬜ LCA of BST · ⬜ Level Order Traversal · ⬜ Right Side View · ⬜ Count Good Nodes · ⬜ Validate BST · ⬜ Kth Smallest in BST · ⬜ Construct Tree from Preorder/Inorder · ⬜ Binary Tree Max Path Sum (hard) · ⬜ Serialize/Deserialize (hard)

### Tries — gate: prefix-tree build + search cold medium
⬜ Implement Trie · ⬜ Design Add and Search Words · ⬜ Word Search II (hard)

### Heaps / Priority Queue — gate: top-K + two-heap cold medium
⬜ Kth Largest Element in Array · ⬜ Last Stone Weight · ⬜ K Closest Points to Origin · ⬜ Task Scheduler · ⬜ Design Twitter · ⬜ Find Median From Data Stream (hard)

### Backtracking — gate: choose/explore/un-choose template cold medium
⬜ Subsets · ⬜ Combination Sum · ⬜ Permutations · ⬜ Subsets II · ⬜ Combination Sum II · ⬜ Word Search · ⬜ Palindrome Partitioning · ⬜ Letter Combinations of a Phone Number · ⬜ N-Queens (hard)

### Graphs — gate: BFS/DFS grid + topo sort + union-find cold medium
⬜ Number of Islands · ⬜ Max Area of Island · ⬜ Clone Graph · ⬜ Pacific Atlantic Water Flow · ⬜ Surrounded Regions · ⬜ Rotting Oranges · ⬜ Course Schedule · ⬜ Course Schedule II · ⬜ Graph Valid Tree · ⬜ Number of Connected Components · ⬜ Redundant Connection · ⬜ Word Ladder (hard) · ⬜ Network Delay Time (Dijkstra) · ⬜ Cheapest Flights Within K Stops

### Greedy & Intervals — gate: exchange-argument + interval sort cold medium
⬜ Maximum Subarray · ⬜ Jump Game · ⬜ Jump Game II · ⬜ Gas Station · ⬜ Hand of Straights · ⬜ Merge Intervals · ⬜ Insert Interval · ⬜ Non-overlapping Intervals · ⬜ Meeting Rooms II

### DP I (1D) — gate: define state + transition cold medium
⬜ Climbing Stairs · ⬜ Min Cost Climbing Stairs · ⬜ House Robber · ⬜ House Robber II · ⬜ Coin Change · ⬜ Maximum Product Subarray · ⬜ Word Break · ⬜ Longest Increasing Subsequence · ⬜ Partition Equal Subset Sum · ⬜ Decode Ways

### DP II (2D / strings / intervals) — gate: 2D state cold medium
⬜ Unique Paths · ⬜ Longest Common Subsequence · ⬜ Best Time to Buy/Sell With Cooldown · ⬜ Coin Change II · ⬜ Target Sum · ⬜ Longest Palindromic Substring · ⬜ Palindromic Substrings · ⬜ Edit Distance · ⬜ Distinct Subsequences · ⬜ Longest Increasing Path in Matrix · ⬜ Burst Balloons (hard) · ⬜ Regular Expression Matching (hard)

### Bit Manipulation — gate: XOR / masking tricks cold easy-medium
⬜ Single Number · ⬜ Number of 1 Bits · ⬜ Counting Bits · ⬜ Reverse Bits · ⬜ Missing Number · ⬜ Sum of Two Integers

---

## How a problem is logged
After each attempt the coach records: `[x]` cold-solved · `~` assisted (requeue +3 days) · time taken · which mastery gate it feeds. Position advances only on `[x]`.
