class Solution {
    public void moveZeroes(int[] nums) {
        int ptr = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[ptr++] = nums[j]; 
            }
        }
        for (int k = ptr; k < nums.length; k++) {
            nums[k] = 0;
        }
    }
}