// 90. Subsets II

// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]


class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        List<Integer> rsf = new ArrayList<>();
        for (int len = 0; len <= nums.length; len++) {
            backtrack(nums, 0, len, rsf);
        }
        return result;
    }
    
    private void backtrack(int[] nums, int pos, int len, List<Integer> rsf) {
        if (rsf.size() == len) {
            result.add(new ArrayList<>(rsf));
        } else {
            int last = Integer.MIN_VALUE;
            for (int i = pos; i < nums.length; i++) {
                if (nums[i] != last) {
                    rsf.add(nums[i]);
                    backtrack(nums, i + 1, len, rsf);
                    rsf.remove(rsf.size() - 1);
                }
                last = nums[i];
            }
        }
    }
}