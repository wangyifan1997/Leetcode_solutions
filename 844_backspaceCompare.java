class Solution {

    public boolean backspaceCompareTwoPointers(String S, String T) {
        int ptrS = S.length() - 1;
        int ptrT = T.length() - 1;
        int count = 0;
        while (ptrS >= 0 || ptrT >= 0) {
            while (ptrS >= 0 && (count > 0 || S.charAt(ptrS) == '#')) {
                if (S.charAt(ptrS) == '#') {
                    count += 1;
                } else {
                    count -= 1;
                }
                ptrS--;
            }
            count = 0;
            while (ptrT >= 0 && (count > 0 || T.charAt(ptrT) == '#')) {
                if (T.charAt(ptrT) == '#') {
                    count += 1;
                } else {
                    count -= 1;
                }
                ptrT--;
            }
            count = 0;
            if (ptrT >= 0 && ptrS >= 0 && S.charAt(ptrS) == T.charAt(ptrT)) {
                ptrS--;
                ptrT--;
            } else {
                break;
            }
        }
        return ptrT == -1 && ptrS == -1;
    }

    public boolean backspaceCompareStack(String S, String T) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!s.empty()) s.pop();
            } else {
                s.push(S.charAt(i));
            }
        }
        Stack<Character> t = new Stack<>();
        for (int j = 0; j < T.length(); j++) {
            if (T.charAt(j) == '#') {
                if (!t.empty()) t.pop();
            } else {
                t.push(T.charAt(j));
            }
        }
        if (s.size() != t.size()) return false;
        while (!s.empty()) {
            if (s.pop() != t.pop()) return false;
        }
        return true;
    }
}