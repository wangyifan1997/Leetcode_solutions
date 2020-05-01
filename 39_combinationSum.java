// 39. Combination Sum

// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

// The same repeated number may be chosen from candidates unlimited number of times.

// Note:

// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// Example 1:

// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//   [7],
//   [2,2,3]
// ]
// Example 2:

// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]

class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> rsf = new ArrayList<>();
        backtrack(candidates, 0, target, 0, rsf);
        return result;
    }
    
    private void backtrack(int[] nums, int pos, int target, int sum, List<Integer> rsf) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(rsf));
            return;
        } else {
            for (int i = pos; i < nums.length; i++) {
                rsf.add(nums[i]);
                backtrack(nums, i, target, sum + nums[i], rsf);
                rsf.remove(rsf.size() - 1);
            }
        }
    }
}