package Rotated_Array;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        int left = 0;
        int right = a.size() - 1;
        int mid = (right + left) / 2;
        while(left != mid && right != mid){
            if (a.get(left) < a.get(mid) && a.get(mid) < a.get(right)){
                return a.get(left);
            } else if (a.get(mid) > a.get(left)){
                if (a.get(left) > a.get(right)){ left = mid; }
                else { right = mid; }
            } else {
                if (a.get(left) > a.get(right)){ right = mid; }
                else { left = mid; }
            }
            mid = (right + left) / 2;
        }
        if (a.get(left) > a.get(right)){
            if (a.get(mid) < a.get(right)){ return a.get(mid); }
            else { return a.get(right); }
        } else {
            if (a.get(mid) < a.get(left)){ return a.get(mid); }
            else { return a.get(left); }
        }
    }
}
