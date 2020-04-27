class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int g = 0;
        while (j < nums.length) {
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if (j < nums.length) {
                g++;
                nums[g] = nums[j];
            }
            i = j;
        }
        return g + 1;
    }
}


class Solution_v2 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}