package interviewProblems.Rotate_Matrix;

import java.util.ArrayList;

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int tmp1, tmp2, tmp3;
        for (int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                tmp1 = a.get(j).get(n - i - 1);
                tmp2 = a.get(n - i - 1).get(n - j - 1);
                tmp3 = a.get(n - j - 1).get(i);
                a.get(j).set(n - i - 1, a.get(i).get(j));
                a.get(n - i - 1).set(n - j - 1, tmp1);
                a.get(n - j - 1).set(i, tmp2);
                a.get(i).set(j, tmp3);
            }
        }
    }
}