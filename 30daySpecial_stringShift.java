class Solution {
    public String stringShift(String s, int[][] shift) {
    	int move = 0;
        for (int[] pair: shift) {
        	if (pair[0] == 0) {
        		move -= pair[1];
        	} else {
        		move += pair[1];
        	}
        }
        move %= s.length();
        if (move == 0) return s;
        if (move < 0) move += s.length();
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, charArray.length - 1);
        reverse(charArray, 0, move - 1);
        reverse(charArray, move, charArray.length - 1);
        return new String(charArray);
    }

    private void reverse(char[] str, int start, int end) {
    	while (start < end) {
    		char temp = str[start];
    		str[start++] = str[end];
    		str[end--] = temp;
    	}
    }
}