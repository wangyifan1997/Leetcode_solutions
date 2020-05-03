// 383. Ransom Note

// Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

// Each letter in the magazine string can only be used once in your ransom note.

// Note:
// You may assume that both strings contain only lowercase letters.

// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: ransomNote.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) - 1 : -1;
            if (count == -1) return false;
            map.put(c, count);
        }
        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] table = new int[128];
        for (char c : magazine.toCharArray()) {
            table[c]++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (--table[c] < 0) return false;
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char c : magazine.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c: ransomNote.toCharArray()) {
            if (--table[c - 'a'] < 0) return false;
        }
        return true;
    }
}

