package interviewProblems.Counting_Carry_Digits;

public class Solution {
    public int numberOfCarryOperations(int n, int m){
        int totalCarry = 0, nDigit, mDigit;
        boolean hasCarry = false;

        while (n > 0 && m > 0){
            nDigit = getLastDigit(n);
            mDigit = getLastDigit(m);
            if ((hasCarry && mDigit + nDigit + 1 >= 10) || (!hasCarry && mDigit + nDigit >= 10)){
                hasCarry = true;
                totalCarry++;
            } else {
                hasCarry = false;
            }
            n /= 10;
            m /= 10;
        }

        while (n == 0 && m > 0){
            mDigit = getLastDigit(m);
            if ((hasCarry && mDigit + 1 >= 10)){
                hasCarry = true;
                totalCarry++;
            } else {
                hasCarry = false;
            }
            m /= 10;
        }

        while (m == 0 && n > 0){
            nDigit = getLastDigit(n);
            if ((hasCarry && nDigit + 1 >= 10)){
                hasCarry = true;
                totalCarry++;
            } else {
                hasCarry = false;
            }
            n /= 10;
        }

        return totalCarry;
    }

    public int getLastDigit(int num){
        return num % 10;
    }
}
