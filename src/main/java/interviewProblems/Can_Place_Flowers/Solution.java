package interviewProblems.Can_Place_Flowers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Edge case of having only 1 position
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1) return true;
        int i = 0, consec = 0, flowers = 0;
        while (i < flowerbed.length) {
            // Count consecutive 0s
            if (flowerbed[i] == 1) consec = 0;
            else consec++;
            // If 3 consec 0s have been found, a flower can be placed
            // Flower is placed in the middle of the 0s
            // If 2 consecutive 0s and it's on the edge, it can be placed
            if (consec == 3 || (consec == 2 && (i == 1 || i == flowerbed.length - 1))) {
                flowers++;
                consec = 1;
            }
            i++;
        }
        return flowers >= n;
    }
}