// 268. Missing Number

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1:

// Input: [3,0,1]
// Output: 2
// Example 2:

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8
// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


class Solution {
    public int missingNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length;
        int mid;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < mid + 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    public int missingNumberSum(int[] nums) {
        int realSum = (1 + nums.length) * nums.length / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return realSum - sum;
    }
}