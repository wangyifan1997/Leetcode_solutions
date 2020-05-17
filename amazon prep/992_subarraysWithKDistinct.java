// 992. Subarrays with K Different Integers

// Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly K.

// (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

// Return the number of good subarrays of A.

 

// Example 1:

// Input: A = [1,2,1,2,3], K = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
// Example 2:

// Input: A = [1,2,1,3,4], K = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

// Note:

// 1 <= A.length <= 20000
// 1 <= A[i] <= A.length
// 1 <= K <= A.length

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return mostK(A, K) - mostK(A, K - 1);
    }
    
    private int mostK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int left = 0, right = 0; right < A.length; right++) {
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);
            while (map.size() > K) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                }
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}