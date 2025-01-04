# Longest Substring Without Repeating Characters

This project implements an optimized solution to find the **length of the longest substring without repeating characters** in a given string using the sliding window technique in Java.

---

## Problem Statement
Given a string `s`, find the length of the longest substring that contains only unique characters. For example:

- Input: `"abcabcbb"`
  - Output: `3` (The substring is "abc")

- Input: `"bbbbb"`
  - Output: `1` (The substring is "b")

- Input: `"pwwkew"`
  - Output: `3` (The substring is "wke")

---

## Optimized Approach: Sliding Window
The sliding window method uses two pointers to efficiently find the longest substring without repeating characters. The approach eliminates the need to repeatedly generate and check substrings, resulting in faster execution.

### Algorithm
1. Use two pointers (`start` and `end`) to represent a sliding window.
2. Use a HashSet to store characters currently in the window.
3. Iterate through the string:
   - If a character is not in the HashSet, add it and move the `end` pointer to expand the window.
   - If a character is already in the HashSet, remove characters from the window starting from `start` until the duplicate character is removed.
4. Keep track of the maximum window size during the iteration.
5. Return the maximum window size as the result.

---

## Implementation

### Java Code
```java
import java.util.HashSet;

public class LongestSubstringOptimized {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        HashSet<Character> uniqueChars = new HashSet<>();

        for (int end = 0; end < s.length(); end++) {
            while (uniqueChars.contains(s.charAt(end))) {
                uniqueChars.remove(s.charAt(start));
                start++;
            }
            uniqueChars.add(s.charAt(end));
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of the longest substring (optimized method): " + lengthOfLongestSubstring(input));
    }
}
```

---

## Explanation of Code

### Main Function (`lengthOfLongestSubstring`):
- **HashSet**:
  - A `HashSet` is used to keep track of the characters in the current sliding window.
- **Sliding Window**:
  - `start` is the beginning index of the window.
  - `end` is the ending index of the window, iterating through the string.
- **Duplicate Check**:
  - If the character at `end` is already in the `HashSet`, increment `start` to shrink the window until the duplicate character is removed.
- **Update Maximum Length**:
  - At each step, calculate the length of the current window (`end - start + 1`) and update `maxLength` if it's larger.

---

## Complexity Analysis

### Time Complexity:
- Each character is added to and removed from the `HashSet` at most once.
- The `end` pointer iterates through the string once.
- Overall time complexity: **O(n)**.

### Space Complexity:
- The `HashSet` stores at most `n` characters (in the worst case, all unique).
- Space complexity: **O(n)**.

---

## Example Walkthrough

### Input: `"abcabcbb"`

1. **Initial State**:
   - `start = 0`, `end = 0`, `uniqueChars = {}`.

2. **Step-by-Step Execution**:
   - Add 'a' to `uniqueChars`, expand the window, `maxLength = 1`.
   - Add 'b', expand the window, `maxLength = 2`.
   - Add 'c', expand the window, `maxLength = 3`.
   - Encounter 'a' (duplicate), shrink the window by removing 'a' from `uniqueChars` and increment `start`.
   - Repeat the process for subsequent characters.

3. **Final Output**:
   - The longest substring without repeating characters is "abc" with length `3`.

---

## Example Input/Output

| Input       | Output | Explanation                  |
|-------------|--------|------------------------------|
| "abcabcbb"  | 3      | Longest substring is "abc". |
| "bbbbb"     | 1      | Longest substring is "b".   |
| "pwwkew"    | 3      | Longest substring is "wke". |
| ""          | 0      | No characters in the string.|

---

## Benefits of Sliding Window Method
- **Efficient Execution**:
  - Reduces the time complexity to **O(n)** compared to the naive **O(n³)** approach.
- **Scalable**:
  - Can handle larger input strings effectively.

---

## Conclusion
The sliding window technique provides an efficient and elegant solution to the problem of finding the longest substring without repeating characters. It balances simplicity and performance, making it a practical choice for real-world applications.

