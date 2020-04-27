class Solution:
    def majorityElement_v1(self, nums: List[int]) -> int:
        dic = {}
        length = len(nums)
        for num in nums:
            dic[num] = dic.get(num, 0) + 1
        for (num, occ) in dic.items():
            if occ > length / 2:
                return num
        return -1


    # Boyer-Moore
    def majorityElement_v2(self, nums: List[int]) -> int:
    	cur = nums[0]
    	count = 0
    	start = True
    	for num in nums:
    		if count == 0 and not start:
    			cur = num
    			count += 1
    		else:
    			if num == cur:
    				count += 1
    				if start:
    					start = False
    			else:
    				count += -1
    	return cur