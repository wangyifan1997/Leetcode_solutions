// 22. Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

class Solution {
    List<String> result;
    
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        result = new ArrayList<>();
        generate(sb, 0, 0, n);
        return result;
    }

    public void generate(StringBuilder sb, int left, int right, int target) {
        if (right > left || (left + right == target * 2 && left != right)) {
            return;
        } else if (left + right == target * 2) {
            result.add(sb.toString());
        } else {
            sb.append('(');
            generate(sb, left + 1, right, target);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            generate(sb, left, right + 1, target);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}