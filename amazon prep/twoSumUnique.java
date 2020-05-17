// Amazon | OA 2019 | Two Sum - Unique Pairs

// Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

// Example 1:

// Input: nums = [1, 1, 2, 45, 46, 46], target = 47
// Output: 2
// Explanation:
// 1 + 46 = 47
// 2 + 45 = 47
// Example 2:

// Input: nums = [1, 1], target = 2
// Output: 1
// Explanation:
// 1 + 1 = 2
// Example 3:

// Input: nums = [1, 5, 1, 5], target = 6
// Output: 1
// Explanation:
// [1, 5] and [5, 1] are considered the same.

class Solution {
	int twoSumUnique(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int numPairs = 0;
		for (int num : map.keySet()) {
			if (map.containsKey(target - num)) {
				if (num != target - num) {
					numPairs += 1;
				} else if (num == target - num && map.get(num) > 1) {
					numPairs += 2;
				}
			}
		}
		return numPairs / 2;
	}
}