import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Find the complement
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i}; // Return indices
            }
            
            // Add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // If no solution exists (not possible in this problem), return an empty array
        return new int[] {};
    }
}
