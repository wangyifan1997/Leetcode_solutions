/* 763. Partition Labels

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only. */

class Solution {
    public List<Integer> partitionLabelsDoublePointer(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashSet<Character> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < S.length()) {
            char endChar = S.charAt(end++);
            char startChar = S.charAt(start);
            set.add(endChar); 
            map.put(endChar, map.get(endChar) - 1);
            if (map.get(endChar) == 0) set.remove(endChar);
            if (set.isEmpty()) {
                result.add(end - start);
                start = end;
            }
        }

        return result;
    }
}