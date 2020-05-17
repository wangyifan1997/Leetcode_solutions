// Amazon | OA 2019 | Find Pair With Given Sum

// Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.

// Conditions:

// You will pick exactly 2 numbers.
// You cannot pick the same element twice.
// If you have muliple pairs, select the pair with the largest number.
// Example 1:

// Input: nums = [1, 10, 25, 35, 60], target = 90
// Output: [2, 3]
// Explanation:
// nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
// Example 2:

// Input: nums = [20, 50, 40, 25, 30, 10], target = 90
// Output: [1, 5]
// Explanation:
// nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
// nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
// You should return the pair with the largest number.

// Input: nums = [0, 0, 30], target = 30
// Output: [0, 1]

class Solution {
    public int[] findPairWithGivenSum(int[] nums, int target) {
        // A single pass version:
    	target -= 30;
        int[] result = new int[2];
        int max = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer pos = map.get(target - nums[i]);
            if (pos != null) {
                if (pos == i) continue;
                if (Math.max(nums[i], target - nums[i]) > max) {
                    result[0] = pos;
                    result[1] = i;
                    max = Math.max(nums[i], target - nums[i]);
                }
            } else {
                if (!map.containsKey(nums[i])) map.put(nums[i], i);
            }
        }
        return result;



        // target -= 30;
        // int[] result = new int[2];
        // int max = -1;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (!map.containsKey(nums[i])) map.put(nums[i], i);
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     Integer pos = map.get(target - nums[i]);
        //     if (pos == null || pos == i) continue;
        //     if (Math.max(nums[i], target - nums[i]) > max) {
        //         result[0] = pos;
        //         result[1] = i;
        //         max = Math.max(nums[i], target - nums[i]);
        //     }
        // }
        // return result;
    }
}