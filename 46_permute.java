// 46. Permutations

// Given a collection of distinct integers, return all possible permutations.

// Example:

// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> rsf = new ArrayList<>();
        backtrack(nums, rsf);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> rsf) {
        if (rsf.size() == nums.length) {
            result.add(new ArrayList<>(rsf));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!rsf.contains(nums[i])) {
                rsf.add(nums[i]);
                backtrack(nums, rsf);
                rsf.remove(rsf.size() - 1);
            }
        }
    }
}