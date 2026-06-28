# Asteroid Collision — Medium
Problem Link: https://leetcode.com/problems/asteroid-collision/
Solved Date: 2026-06-21
Pattern Tag: simulation-stack

## SRS Tracking
- Stage: 3
- Review Date: 2026-06-28
- Last Rating: Strong
- Review Count: 1
- Graduated: No

---

> Backfilled from your solved code. Analogy / Mental-Model table / Dry Run to be filled on first review.

## Core Insight
Simulation: the stack is the live set of survivors; an incoming left-mover settles against right-movers on top in a loop.

## Watch Out For
- Only (+ on top, - incoming) collides; equal sizes both die; use while, not if.

## Boiler Plate Template
```java
package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode #735 - Asteroid Collision
 * https://leetcode.com/problems/asteroid-collision/
 *
 * Each asteroid moves at the same speed; sign gives direction (+ right, - left)
 * and absolute value gives size. When two collide, the smaller explodes; if equal,
 * both explode. Asteroids moving the same direction never meet. Return the state
 * after all collisions.
 *
 * Implement asteroidCollision, then run main to check against the test cases.
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            // While we have a collision (right-mover on top, left-mover current)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                // If the top (right-mover) is smaller, it gets destroyed
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    stack.pop();
                    continue; // Check the next asteroid in the stack
                }
                // If they are equal size, both get destroyed
                else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                // If the top is larger, the current asteroid is destroyed
                else {
                    destroyed = true;
                    break;
                }
            }

            // If the incoming asteroid wasn't destroyed, add it to the stack
            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert to int array
        return stack.stream().mapToInt(i -> i).toArray();
    }

    // --- Test ---
    private static int passed = 0, failed = 0;

    private static void check(String name, int[] asteroids, int[] expected) {
        int[] actual = new AsteroidCollision().asteroidCollision(asteroids);
        boolean ok = Arrays.equals(actual, expected);
        if (ok) passed++; else failed++;
        System.out.printf("%-7s %-14s asteroids=%s -> got=%s expected=%s%n",
                ok ? "PASS" : "FAIL", name,
                Arrays.toString(asteroids), Arrays.toString(actual), Arrays.toString(expected));
    }

    public static void main(String[] args) {
        check("example1", new int[]{5, 10, -5}, new int[]{5, 10});
        check("example2", new int[]{8, -8}, new int[]{});
        check("example3", new int[]{10, 2, -5}, new int[]{10});
        check("allRight", new int[]{1, 2, 3}, new int[]{1, 2, 3});
        check("allLeft", new int[]{-1, -2, -3}, new int[]{-1, -2, -3});
        check("passBy", new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2});
        check("single", new int[]{7}, new int[]{7});
        check("chainExplode", new int[]{10, 2, -5, -5}, new int[]{10});
        check("equalDestroy", new int[]{5, -5}, new int[]{});
        check("bigLeftWins", new int[]{1, 2, 3, -10}, new int[]{-10});

        System.out.printf("%n%d passed, %d failed%n", passed, failed);
    }
}
```
