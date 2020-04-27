class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int[] bestAt = new int[nums.length];
        bestAt[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (bestAt[i - 1] < 0) {
                bestAt[i] = nums[i];
            } else {
                bestAt[i] = nums[i] + bestAt[i - 1];
            }
            if (bestAt[i] > best) {
                best = bestAt[i];
            }
        }
        return best;
    }
}