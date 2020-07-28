package Implement_StrStr;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if (A == null || A.isEmpty() || B == null || B.isEmpty()){ return -1;}
        int[] pos = this.computePattern(B);
        int ai = 0;
        int posi = 0;
        while (ai < A.length()){
            if (B.charAt(posi) == A.charAt(ai)) {
                posi++;
                ai++;
            }
            if (posi == B.length()) {
                return ai - posi;
            } else if (ai < A.length() && B.charAt(posi) != A.charAt(ai)) {
                if (posi != 0)
                    posi = pos[posi - 1];
                else
                    ai++;
            }
        }
        return -1;
    }

    public int[] computePattern(String pat){
        int len = 0;
        int i = 1;
        int[] arr = new int[pat.length()];
        arr[0] = 0;
        while (i < pat.length()){
            if (pat.charAt(i) == pat.charAt(len)){
                len++;
                arr[i] = len;
                i++;
            } else {
                if (len > 0){
                    len = arr[len - 1];
                } else {
                    arr[i++] = len;
                }
            }
        }
        return arr;
    }
}
