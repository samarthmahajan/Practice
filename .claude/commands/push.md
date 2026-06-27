Commit all current changes and push them to GitHub (repo: https://github.com/samarthmahajan/Practice).

Run these steps in order:

## 1 — Survey
Run `git status --short` and `git diff --stat` to see what changed.
- If there is NOTHING to commit and the branch is already in sync with origin, say "Nothing to push — already up to date" and STOP.

## 2 — Stage
Stage everything: `git add -A`.

## 3 — Commit message
Write a clear, conventional commit message based on what actually changed — do NOT use a generic "update" message:
- New solved problem(s) → `solve: <Problem Name(s)>`
- New/edited pattern card or cheatsheet → `notes: <what changed>`
- Plan / REVIEW.md updates → `plan: <what changed>`
- Mixed → a short summary line + a bullet body listing the main changes.
Always end the message with:
```
Co-Authored-By: Claude Opus 4.8 <noreply@anthropic.com>
```

## 4 — Commit
Run the commit. The repo's `post-commit` hook auto-pushes to `origin/<branch>`, so a successful commit normally pushes by itself.

## 5 — Confirm push
Run `git status -sb`. If it still shows commits ahead of origin (hook didn't push, e.g. was offline), run `git push` explicitly.
Report the final result: the commit subject line and confirmation that `origin/main` is in sync. Include the repo URL.
