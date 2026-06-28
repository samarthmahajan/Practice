# Simplify Path — Medium
Problem Link: https://leetcode.com/problems/simplify-path/
Solved Date: 2026-06-21
Pattern Tag: simulation-stack

## SRS Tracking
- Stage: 3
- Review Date: 2026-07-02
- Last Rating: Strong
- Review Count: 2
- Graduated: No

---

> Backfilled from your solved code. Analogy / Mental-Model table / Dry Run to be filled on first review.

## Core Insight
Split on '/': '..' pops, '.'/empty skip, anything else pushes; rejoin with '/'.

## Watch Out For
- '..' at root is a no-op; collapse multiple slashes; no trailing slash except root.

## Boiler Plate Template
```java
package stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode #71 - Simplify Path
 * https://leetcode.com/problems/simplify-path/
 *
 * Given an absolute Unix-style path, return its simplified canonical path:
 * a single slash between names, no trailing slash, '.' means current directory,
 * '..' goes up one level, and multiple slashes collapse to one.
 *
 * Implement simplifyPath, then run main to check against the test cases.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strArray = Arrays.stream(path.split("/+"))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        for (String dir : strArray){
            if("..".equals(dir) && !stack.isEmpty()){
                stack.pop();
                continue;
            }else if (".".equals(dir)  || "..".equals(dir)){
                continue;
            }
            stack.push(dir);
        }

         return "/" + String.join("/", stack);

    }

    // --- Test ---
    private static int passed = 0, failed = 0;

    private static void check(String name, String path, String expected) {
        String actual = new SimplifyPath().simplifyPath(path);
        boolean ok = Objects.equals(actual, expected);
        if (ok) passed++; else failed++;
        System.out.printf("%-7s %-16s path=%-34s -> got=%-18s expected=%s%n",
                ok ? "PASS" : "FAIL", name,
                "\"" + path + "\"", "\"" + actual + "\"", "\"" + expected + "\"");
    }

    public static void main(String[] args) {
        check("example1", "/home/", "/home");
        check("example2", "/home//foo/", "/home/foo");
        check("example3", "/home/user/Documents/../Pictures", "/home/user/Pictures");
        check("example4", "/../", "/");
        check("example5", "/.../a/../b/c/../d/./", "/.../b/d");
        check("root", "/", "/");
        check("multiSlash", "/a//b////c/d//././/..", "/a/b/c");
        check("trailingDotDot", "/a/./b/../../c/", "/c");
        check("manyUp", "/../../../", "/");
        check("dotsName", "/a/...", "/a/...");

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
```
