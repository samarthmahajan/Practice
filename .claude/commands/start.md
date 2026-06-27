Read @plans/PLAN.md first, then @notes/REVIEW.md.

## Check 0 — Follow the Plan (highest priority)
@plans/PLAN.md is the source of truth while a topic is in progress.
- If today is a NEW topic in the plan (no problems yet from it), do the conceptual dive (Concept / When to use / How to identify / Core Patterns) BEFORE suggesting any problem.
- Before trusting the checkboxes, CROSS-CHECK against reality: a curated problem already has a solved file in `src/<topic>/` (e.g. `DecodeString.java`) counts as DONE even if its box is unticked — tick it and move on. This keeps position correct even if a prior session forgot to update the plan.
- Otherwise announce the active topic + the next unchecked question from the plan's curated ladder, with its LeetCode link. Give ONE Socratic nudge (per the plan), no solution.
- Respect capacity: ≤4 problems on weekdays. If I've already hit today's count, say so and suggest reviews instead.
- Only fall through to the SRS checks below if the plan has no active topic or all curated questions are checked off.

Run these checks in order and show the first one that applies:

## Link Rule (applies to ALL checks)
Always display the Problem Link for every problem announced — sprint due, suggested, or gap.
Fetch the link from the problem's solved note file (grep "Problem Link").
Never announce a problem without its link.

## Check 1 — Pattern Lock Sprint Active?
Find any Stage 1 or Stage 2 problem whose Review Date is today or overdue.
If found → show a table with columns: Problem | Stage | Due | Link
Include ALL overdue/due sprint problems, each with its Problem Link.
Announce: "Sprint active. Run /review-dsa first before starting a new problem."

## Check 2 — 3-Problem Rule: Pattern in Progress?
Find the most recently added pattern tag (last few rows of REVIEW.md).
Count how many problems share that tag across all rows.
If < 3 → announce: "Pattern [tag] has [N]/3 problems. Suggested next:" and give one unseen problem from that same tag — include its Problem Link.
Follow the full coaching flow from CLAUDE.md once I confirm.

## Check 3 — Pattern Gap?
Find pattern tags not seen in any Review Date within the last 7 days.
Pick the tag with the oldest last-review date as the gap.
Announce: "Gap found: [tag] — last practiced [date]. Suggested:" and give one unseen problem from that tag — include its Problem Link.
Follow the full coaching flow from CLAUDE.md once I confirm.

## If no checks fire
All patterns are fresh and at 3+ problems.
Announce: "All patterns solid. Time to start a new one. Picking from your weakest area..." and suggest the next pattern based on MAANG frequency (DP > Backtracking > Greedy > advanced graph > rest).
