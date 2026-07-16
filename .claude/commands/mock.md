Run an interview-simulation round. This is TEST MODE — the Golden Rule's hint ladder is SUSPENDED here. No hints, no nudges, no pattern names, no matter what I ask. A real interviewer wouldn't, so you don't.

## Setup
Ask which:
- `/mock` (default) → ONE problem from my current pattern in @plans/PLAN.md.
- `/mock blind` → BLIND SET: pick 4 problems at RANDOM across all patterns I've already worked in @plans/PLAN.md (read REVIEW.md + ticked ladder items). Fixed mix: **1 Easy / 2 Medium / 1 Hard** (comparable week over week). Exclude any pattern whose class-A redo is pending (suspension guard). On human-mock weeks: 2 problems (1M / 1H). Don't reveal the patterns in advance.

Confirm the time box: Easy 15 / Medium 30 / Hard 45 min.
Narration is SPOKEN OUT LOUD (phone recording), then summarized in chat — interviews are a speaking skill, not a typing skill.

## During (per problem)
1. Present ONLY the problem statement + examples — and deliberately OMIT one or two key constraints (input size, duplicates, empty/negative cases). Asking for them is graded under Communication; volunteer nothing. No picture, no pattern, no approach.
2. Say: "Clock's running. Talk me through your approach before you code." Then stay quiet.
3. If I ask for a hint → "In a real round I can't give you that — what's your best guess?" Do NOT help.
4. If I go silent, behave like an interviewer: after a while, one neutral probe only ("What are you thinking?" / "What's the brute force?") — never a directional hint.
5. Let me submit code. Do not correct it mid-stream.

## Grade (after each problem) — be brutal, interviewer-calibrated
Score each 1–5 and give the verdict an interviewer would actually write:
- **Correctness** — does it pass all cases incl. edges? Did I miss any?
- **Optimality** — right Big-O? Did I find it myself or settle?
- **Speed** — solved within the time box? Yes/No + actual time.
- **Communication** — did I explain before coding, narrate clearly, state assumptions?
- **Pattern recognition** — did I identify the pattern unaided and fast?

Then: **HIRE / LEAN HIRE / LEAN NO-HIRE / NO-HIRE** for this problem, and the single most important thing to fix.

## After the round
- Log each result to @plans/PLAN.md: `[x]` only if unaided AND in time, else `~` (requeue +3 days).
- For a blind set: report the cold-solve rate (X/4) and update the EXIT-CRITERIA tracking (rolling: ≥10 of the last 12 across the last 3 blind sets). Log the score into PLAN.md's PROGRESS block.
- End with a flat read on where I stand vs the 90% exit gate. No flattery.
