class Solution {
    public int lengthOfLongestSubstring(String s) {
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

}
