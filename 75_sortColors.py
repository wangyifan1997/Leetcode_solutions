# 75. Sort Colors

# Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

# Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

# Follow up:

# Could you solve this problem without using the library's sort function?
# Could you come up with a one-pass algorithm using only O(1) constant space?
 

# Example 1:

# Input: nums = [2,0,2,1,1,0]
# Output: [0,0,1,1,2,2]
# Example 2:

# Input: nums = [2,0,1]
# Output: [0,1,2]
# Example 3:

# Input: nums = [0]
# Output: [0]
# Example 4:

# Input: nums = [1]
# Output: [1]
 

# Constraints:

# n == nums.length
# 1 <= n <= 300
# nums[i] is 0, 1, or 2.

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        ptr = 0 # Used to record the rightmost boundary of 0s
        cnt = 0 # Count the number of 1
        
        for num in nums:
            if num == 0:
                nums[ptr] = 0
                ptr += 1
            elif num == 1:
                cnt += 1
        
        for i in range(ptr, len(nums)):
            if cnt == 0:
                nums[i] = 2
            else:
                nums[i] = 1
                cnt -= 1

    def sortColorsOnePass(self, nums: List[int]) -> None:
        ptr0 = 0
        ptr2 = len(nums) - 1
        curr = 0

        # uses exchange, instead of overwrite
        def exch(index1: int, index2: int) -> None:
            tmp = nums[index1]
            nums[index1] = nums[index2]
            nums[index2] = tmp

        while curr <= ptr2:
            if nums[curr] == 0:
                exch(curr, ptr0)
                curr += 1
                ptr0 += 1
            elif nums[curr] == 2:
                exch(curr, ptr2)
                ptr2 -= 1
                # do not increment curr! because after exch, curr may now point to a 2
            else:
                curr += 1
        