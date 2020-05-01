// 784. Letter Case Permutation

// Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

// Examples:
// Input: S = "a1b2"
// Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

// Input: S = "3z4"
// Output: ["3z4", "3Z4"]

// Input: S = "12345"
// Output: ["12345"]
// Note:

// S will be a string with length between 1 and 12.
// S will consist only of letters or digits.

class Solution {
    List<String> result;
    
    public List<String> letterCasePermutation(String S) {
        result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(S, 0, stringBuilder);
        return result;
    }
    
    private void backtrack(String S, int pos, StringBuilder stringBuilder) {
        if (pos == S.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        char c = S.charAt(pos);
        if (Character.isDigit(c)) {
            stringBuilder.append(c);
            backtrack(S, pos + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            stringBuilder.append(Character.toUpperCase(c));
            backtrack(S, pos + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append(Character.toLowerCase(c));
            backtrack(S, pos + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}