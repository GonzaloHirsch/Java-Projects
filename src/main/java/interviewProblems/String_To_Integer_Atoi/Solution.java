package interviewProblems.String_To_Integer_Atoi;

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int sum = 0;
        boolean first = true;
        int sign = 1;
        for (char c : str.toCharArray()){
            if (first){
                first = false;
                if (c == '-'){
                    sign = -1;
                } else if (c == '+'){
                    sign = 1;
                } else if (isNum(c)){
                    sign = 1;
                    sum = (sum * 10) + num(c);
                } else {
                    return 0;
                }
            } else {
                if (isNum(c)){
                    try{
                        sum = Math.multiplyExact(sum, 10);
                        sum = Math.addExact(sum, num(c));
                    } catch (ArithmeticException e){
                        if (sign > 0){
                            return (int)(Math.pow(2, 31) - 1);
                        } else {
                            return (int)(Math.pow(2, 31) * -1);
                        }
                    }

                } else {
                    return sum * sign;
                }
            }
        }
        return sum * sign;
    }

    public boolean isNum(char c){
        return c >= '0' && c <= '9';
    }

    public int num(char c){
        return Character.getNumericValue(c);
    }
}
