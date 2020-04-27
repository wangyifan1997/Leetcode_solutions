// 17. Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example:

// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:

// Although the above answer is in lexicographical order, your answer could be in any order you want.

class Solution {
    List<String> result;
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        result = new ArrayList<>();
        String[] str = new String[digits.length()];
        for (int i = 0; i < str.length; i++) {
            str[i] = map.get(digits.charAt(i));
        }
        char[] rsf = new char[str.length];
        helper(str, 0, rsf);
        return result;
    }
    
    private void helper(String[] str, int pos, char[] rsf) {
        if (pos == str.length) {
            result.add(new String(rsf));
            return;
        }
        for (int i = 0; i < str[pos].length(); i++) {
            rsf[pos] = str[pos].charAt(i);
            helper(str, pos + 1, rsf);
        }
    }
}