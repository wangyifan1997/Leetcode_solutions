class Solution:
    def hammingWeight_v1(self, n: int) -> int:
        return sum([1 if letter == "1" else 0 for letter in str(bin(n))[2:]])


    def hammingWeight_v2(self, n: int) -> int:
    	return bin(n).count("1")


    
