# Longest Substring Without Repeating Characters (Brute Force)

This project implements a brute force solution to find the **length of the longest substring without repeating characters** in a given string using Java.

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

## Brute Force Approach
The brute force method generates all possible substrings and checks if each substring contains unique characters. It then returns the maximum length of such substrings.

### Algorithm
1. **Iterate over all substrings**:
   - Use two nested loops where:
     - `i` is the starting index of the substring.
     - `j` is the ending index of the substring.

2. **Check uniqueness**:
   - For each substring `s[i..j]`, check if all characters are unique.
   - Use a helper function `isUnique` that uses a boolean array to track visited characters.

3. **Update the maximum length**:
   - If a substring is unique, calculate its length as `j - i + 1`.
   - Update the maximum length if this length is greater than the previously stored value.

4. **Return the result**:
   - Return the maximum length after iterating through all substrings.

---

## Implementation

### Java Code
```java
public class LongestSubstringBruteForce {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        // Iterate over all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isUnique(s, i, j)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    // Helper method to check if all characters in the substring are unique
    private static boolean isUnique(String s, int start, int end) {
        boolean[] charSet = new boolean[128]; // Assume ASCII characters

        for (int k = start; k <= end; k++) {
            if (charSet[s.charAt(k)]) {
                return false; // Duplicate character found
            }
            charSet[s.charAt(k)] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of the longest substring (brute force): " + lengthOfLongestSubstring(input));
    }
}
```

---

## Explanation of Code

### Main Function (`lengthOfLongestSubstring`):
- **Outer Loop (`i`)**:
  - Iterates over all possible starting indices of substrings.
- **Inner Loop (`j`)**:
  - Iterates over all possible ending indices of substrings, starting from `i`.
- **Helper Function (`isUnique`)**:
  - Checks if all characters in the substring `s[i..j]` are unique using a boolean array `charSet`.
- **Update Maximum Length**:
  - If the substring is unique, calculate its length as `j - i + 1` and update the maximum length.

### Helper Function (`isUnique`):
- A boolean array `charSet` of size 128 is used to represent ASCII characters.
- For each character in the substring, check if it already exists in `charSet`:
  - If it exists, return `false` (not unique).
  - Otherwise, mark the character as seen.

---

## Complexity Analysis

### Time Complexity:
- The **outer loop** runs **O(n)**.
- The **inner loop** also runs **O(n)**.
- For each substring, the `isUnique` function takes **O(n)** in the worst case to check uniqueness.
- Total time complexity: **O(n³)**.

### Space Complexity:
- The `isUnique` function uses a boolean array of size 128 (constant size for ASCII characters).
- Space complexity: **O(1)**.

---

## Example Walkthrough

### Input: `"abcabcbb"`

1. **Outer Loop (`i = 0`)**:
   - **Inner Loop (`j = 0`)**: Substring = "a", unique = true, maxLength = 1.
   - **Inner Loop (`j = 1`)**: Substring = "ab", unique = true, maxLength = 2.
   - **Inner Loop (`j = 2`)**: Substring = "abc", unique = true, maxLength = 3.
   - **Inner Loop (`j = 3`)**: Substring = "abca", unique = false.

2. **Outer Loop (`i = 1`)**:
   - Repeat the process for substrings starting at index `1`.

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

## Limitations of the Brute Force Approach
- **Inefficient for large strings**:
  - Due to its **O(n³)** time complexity, this approach is not suitable for long input strings.
- **Optimized Approach**:
  - Use the **sliding window technique** to reduce time complexity to **O(n)**.

---

## Conclusion
The brute force solution is a simple and straightforward way to solve the problem of finding the longest substring without repeating characters. While it is not efficient for larger inputs, it provides a clear understanding of the problem and is useful as a stepping stone toward implementing optimized algorithms.

