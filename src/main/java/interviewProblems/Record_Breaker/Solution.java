package interviewProblems.Record_Breaker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner sc;

    public static void main(String[] args)
    {
        Solution s = new Solution();
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseTotal = sc.nextInt(), caseN;
        int[] caseArr;
        for(int i = 0; i < caseTotal; i++){
            caseN = sc.nextInt();
            caseArr = new int[caseN];
            for (int j = 0; j < caseN; j++){
                caseArr[j] = sc.nextInt();
            }
            System.out.println("Case #" + (i+1) + ": " + s.solve(caseArr));
        }
    }

    public int solve(int[] data){
        int max = 0, total = 0, n = data.length;
        for (int i = 0; i < n; i++){
            boolean isGTMax = i == 0 || data[i] > max;
            boolean isGTAll = i == n - 1 || data[i] > data[i + 1];
            if (isGTMax && isGTAll){
                total++;
            }
            max = Math.max(data[i], max);
        }
        return total;
    }
}