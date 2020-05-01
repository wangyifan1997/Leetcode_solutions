// 77. Combinations

// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// Example:

// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> rsf = new ArrayList<>();
        backtrack(1, n, k, rsf);
        return result;
    }
    
    private void backtrack(int start, int n, int k, List<Integer> rsf) {
        if (rsf.size() == k) {
            result.add(new ArrayList(rsf));
            return;
        }
        for (int i = start; i <= n; i++) {
            rsf.add(i);
            backtrack(i + 1, n, k, rsf);
            rsf.remove(rsf.size() - 1);
        }
    }
}