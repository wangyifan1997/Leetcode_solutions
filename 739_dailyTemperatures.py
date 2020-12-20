# 739. Daily Temperatures

# Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

# For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

# Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        output = [0 for _ in T]
        maxIndex = len(T) - 1
        
        for i in range(maxIndex - 1, -1, -1):
            if T[i + 1] > T[i]:
                output[i] = 1
            else:
                index = i + 1
                step = 1
                while T[index] <= T[i]:
                    if index == maxIndex or output[index] == 0:
                        step = 0
                        break
        
                    step += output[index]
                    index += output[index]
                
                output[i] = step
        
        return output