// 40. Combination Sum II

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

// Each number in candidates may only be used once in the combination.

// Note:

// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5,
// A solution set is:
// [
//   [1,2,2],
//   [5]
// ]

class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        List<Integer> rsf = new ArrayList<>();
        backtrack(candidates, 0, rsf, 0, target);
        return result;
    }
    
    private void backtrack(int[] nums, int pos, List<Integer> rsf, int sum, int target) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(rsf));
        } else {
            int last = 0;
            for (int i = pos; i < nums.length; i++) {
                if (nums[i] != last) {
                    rsf.add(nums[i]);
                    backtrack(nums, i + 1, rsf, sum + nums[i], target);
                    rsf.remove(rsf.size() - 1);
                }
                last = nums[i];
            }
        }
    }
}