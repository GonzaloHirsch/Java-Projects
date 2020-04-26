package Reverse_Integer;

import java.util.ArrayDeque;

public class Solution {
    public int reverse(int x) {
        int max = (int)Math.pow(2, 31) - 1;
        int min = -1 * (int)Math.pow(2, 31);
        ArrayDeque<Integer> sk = new ArrayDeque<>();
        boolean negative = false;
        if (x < 0){
            negative = true;
            x = x * -1;
        }
        while (x > 0){
            sk.add(x % 10);
            x = x / 10;
        }
        Integer num = sk.poll();
        while(num != null){
            try{
                x = Math.multiplyExact(x, 10);
                x = Math.addExact(x, num);
            } catch (Exception e){
                return 0;
            }
            num = sk.poll();
        }
        if (negative){
            try{
                x = Math.multiplyExact(x, -1);
            } catch (Exception e){
                return 0;
            }
        }
        return x;
    }
}
