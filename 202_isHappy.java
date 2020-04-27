import java.lang.Math; 

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (!seen.add(n)) {
                return false;
            }
            n = calculateDigit(n);
        }
        return true;
    }
    
    private int calculateDigit(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow((n % 10), 2);
            n /= 10;
        }
        return sum;
    }
}