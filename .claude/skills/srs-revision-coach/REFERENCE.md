# SRS Revision Coach — Mode Execution Reference

## ALWAYS Show the Problem Statement (every mode, no exceptions)
In every mode, alongside the problem name and link, display a concise **problem statement** — the actual task: inputs → expected output, plus any key constraint. The user must know *exactly what the problem asks* without clicking the link.
- Pull it from the card's problem statement if present; otherwise state it cold in 1–3 lines.
- The statement describes the problem ONLY. It must never reveal the pattern, approach, data structure, or solution — that's still the user's to recall.

## Full Mode — Step by Step
1. Read `Problem Link:` field from the card before showing anything.
2. Cheatsheet Prime: look up card's Pattern Tag in `@notes/cheatsheets/cheatsheet-index.md`, output one line: `📖 [tag] → [file] § [section]`. Full mode only — skip for Snippet/Blitz.
3. Show problem name, problem link, AND a concise problem statement (task: inputs → expected output, key constraint). No tag, no approach, no card yet.
4. Wait for recall attempt.
5. "hint" → one nudge, direction only, no algorithm name.
6. "blank" / "timeout" / "no clue" → mark Blank, show card immediately, move on.
7. Test case requests → ALWAYS use the exact test case from the card's Dry Run section. Never invent one.
8. After attempt: ask "What's the time and space complexity?" — wait for answer, then reveal card, compare what was right vs missed, factor complexity into rating.

## Snippet Mode — Step by Step
Snippet = boilerplate as comments + full code only for tricky parts.
1. Show problem name, problem link, AND a concise problem statement (task: inputs → expected output, key constraint). No tag, no approach, nothing else.
2. Prompt: "Write comments for parts you know cold + full code for parts you think are tricky."
3. "blank" / "timeout" / "no clue" → mark Blank, show full card, move on.
4. After attempt:
   - Verify comments show correct understanding of flow.
   - Verify code snippets are correct (focus on card's Watch Out For sections).
   - If a critical part has no comment AND no code → ask user to cover it before rating.
   - Ask "What's the time and space complexity?" — wait for answer.
   - Once coverage + complexity are complete and correct → rate immediately, no follow-up.
5. Rating rules:
   - Comments wrong on flow → Weak regardless of code.
   - Critical code snippet has a bug → Okay at best, Weak if severe.
   - Wrong complexity with correct code → cap at Okay.
   - Complete and correct → rate immediately and move on.

## Blitz Mode — Step by Step
1. Show problem name, problem link, and a one-line problem statement. Then: "Problem: [name] — [tag] · Core insight in one sentence: ___?"
2. "yes" → follow up: "Time and space?" — correct → Strong, next problem instantly; wrong → Okay.
3. "no" → show core insight from card, Blank, move on.
4. No pseudocode, no discussion.

## Sprint Mode (Stage 1 and Stage 2 only)
Sprint = first 2 SRS review cycles after a weak solve. Announce "🏃 Sprint active" at start of each sprint review.

| Stage at review | Sprint label | Mode used | Task |
|---|---|---|---|
| Stage 1 | Sprint Day+1 | Full | Explain core insight + approach cold. No notes, no cheatsheet. |
| Stage 2 | Sprint Day+3 | Snippet | Write full Java boilerplate cold. No peeking at card or cheatsheet. |

- Pass (Okay or Strong) → bump Stage normally per SRS intervals.
- Fail (Weak or Blank) → stay at same Stage, Review Date = today + 1, retry tomorrow.
- Missed sprint (overdue) → run sprint review now, no penalty for lateness.

## Overdue Triage
Any problem overdue 3+ days → force Blitz mode regardless of Stage or Last Rating.
Goal: clear the debt fast. Correct core-insight recall counts as Okay minimum.
Exception: Stage 1 or Stage 2 → Sprint Mode takes priority over Blitz. Never skip sprint.
Suspended rows: a REVIEW.md row whose Review Date reads `SUSP → redo …` is class-A-suspended — never queue it; the redo supersedes the review.
Class-B cards (missed-WHY comment at the top of the card): the FIRST prompt of any mode is that WHY, cold, before anything else.

## Double-Strong Fast-Track (Stages 3–5, generalized v3 2026-07-12)
If a Stage 3–5 problem was rated Strong last review AND is rated Strong again now → advance TWO stages instead of one (3→5, 4→6 graduated, 5→6 graduated).
Do not wait out the remaining cycle. Update Stage in both the card and REVIEW.md.
Check: if Last Rating = Strong before this review, current Strong = fast-track.
Rationale: a card proven twice at long spacing is retention-safe — the Saturday blind set is the backstop that catches false graduations.
