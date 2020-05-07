// 349. Intersection of Two Arrays

// Given two arrays, write a function to compute their intersection.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Note:

// Each element in the result must be unique.
// The result can be in any order.

class Solution {
    public int[] intersectionTwoSets(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        HashSet<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) intersection.add(num);
        }
        int[] result = new int[intersection.size()];
        int count = 0;
        for (int num : intersection) result[count++] = num;
        return result;
    }

    public int[] intersectionSorting(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        int size = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] temp = new int[size];
        int count = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                if (p1 == 0 
                    || p2 == 0 
                    || (nums1[p1] != nums1[p1 - 1] && nums2[p2] != nums2[p2 - 1])) {
                    temp[count++] = nums1[p1];    
                }
                p1++;
                p2++;
            }
        }
        return Arrays.copyOfRange(temp, 0, count);
    }
}