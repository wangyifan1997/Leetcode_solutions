// 78. Subsets
// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

class Solution {
	List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new LinkedList<>();
        List<Integer> rsf = new LinkedList<>();
        helper(nums, 0, rsf);
        return result;
    }

    private void helper(int[] nums, int pos, List<Integer> rsf) {
    	if (pos == nums.length) {
    		result.add(new LinkedList(rsf));
    		return;
    	}
        rsf.add(nums[pos]);
        helper(nums, pos + 1, rsf);
        rsf.remove(rsf.size() - 1);
        helper(nums, pos + 1, rsf);
    }	
}