import java.util.Set;
import java.util.HashSet;


class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num: nums) {
            if (!numberSet.contains(num)) {
                numberSet.add(num);
            } else {
                numberSet.remove(num);
            }
        }
        return (int) numberSet.toArray()[0];
    }
}