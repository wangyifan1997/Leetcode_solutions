import java.lang.*;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] best = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i = 0) {
                best[i] = nums[i];
            } else if (i = 1) {
                best[i] = Math.max(nums[i], nums[i - 1]);
            } else {
                best[i] = Math.max(best[i - 2] + nums[i], best[i - 1]);
            }
        }
        return best[best.length - 1];
    }
}