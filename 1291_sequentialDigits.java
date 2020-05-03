// 1291. Sequential Digits

// An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

// Example 1:

// Input: low = 100, high = 300
// Output: [123,234]
// Example 2:

// Input: low = 1000, high = 13000
// Output: [1234,2345,3456,4567,5678,6789,12345]

class Solution {
    List<Integer> result;
    
    public List<Integer> sequentialDigits(int low, int high) {
        result = new ArrayList<>();
        String lowerBound = Integer.toString(low);
        String upperBound = Integer.toString(high);
        int lenLowerBound = lowerBound.length();
        int lenUpperBound = upperBound.length();
        for (int len = lenLowerBound; len <= lenUpperBound; len++) {
            int start;
            if (len == lenLowerBound) start = Character.getNumericValue(lowerBound.charAt(0));
            else start = 1;
            generate(len, start, low, high);
        }
        return result;
    }
    
    private void generate(int len, int start, int low, int high) {
        for (int i = start; i <= 10 - len; i++) {
            int rsf = 0;
            int count = len;
            for (int j = i; j < i + len; j++) {
                if (count < 0) break;
                rsf += j * Math.pow(10, count - 1);
                count--;
            }
            if (rsf <= high && rsf >= low) result.add(rsf);
        }
    }
}