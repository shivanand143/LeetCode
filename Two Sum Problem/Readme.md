

# Two Sum Problem - LeetCode

## Problem Description

Given an array of integers `nums` and an integer `target`, return **indices of the two numbers** such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order.

### Examples

#### Example 1:
```text
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```

#### Example 2:
```text
Input: nums = [3,2,4], target = 6
Output: [1,2]
Explanation: Because nums[1] + nums[2] == 6, we return [1, 2].
```

#### Example 3:
```text
Input: nums = [3,3], target = 6
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 6, we return [0, 1].
```

### Constraints
- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `-10^9 <= target <= 10^9`
- **Only one valid answer exists.**

---

## Solution Explanation

### Approach:
We use a **HashMap** to store numbers we've seen so far and their indices. As we iterate through the array, we calculate the complement (`target - nums[i]`) and check if it already exists in the map. If it does, we return the indices of the current number and its complement.

### Code Implementation:

```java
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
```

---

## Explanation of the Code:

1. **Initialize a HashMap**:
   - The `HashMap` stores numbers as keys and their indices as values.

2. **Iterate Through the Array**:
   - For each element in `nums`, calculate its complement: `target - nums[i]`.

3. **Check for Complement**:
   - If the complement exists in the `HashMap`, it means we’ve found the two numbers. Return their indices.

4. **Add Current Number to HashMap**:
   - If the complement isn’t found, store the current number and its index in the map.

---

### Complexity Analysis:

- **Time Complexity**:  
  - Each lookup or insertion in the `HashMap` takes **O(1)**.  
  - Since we iterate through the array once, the overall time complexity is **O(n)**.

- **Space Complexity**:  
  - The `HashMap` stores at most `n` elements, so the space complexity is **O(n)**.

---

Let me know if you'd like any changes or additions!
