package interviewProblems.Maximum_XOR_After_Operations;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumXOR(int[] nums) {
        int result = 0;
        String bits;
        int n, number;
        // Set to remove repeated elements
        Set<Integer> mem = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            number = nums[i];
            if (!mem.contains(number)) {
                mem.add(number);
                // Get bit representation, take into consideration
                // that it returns it from the first one onwards
                bits = Integer.toBinaryString(number);
                n = bits.length() - 1;
                // Iterate until it ends or manages to set bit
                for (int b = 0; b <= n; b++) {
                    if (hasBitAsOne(number, n - b)) {
                        result = setBit(result, n - b);
                    }
                }
            }
        }
        return result;
    }

    public int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    public boolean hasBitAsOne(int x, int bit) {
        int tmp = (1 << bit);
        return (x & tmp) == tmp;
    }
}

/*
class Solution {
    public int maximumXOR(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result | nums[i];
        }
        return result;
    }
}
* */