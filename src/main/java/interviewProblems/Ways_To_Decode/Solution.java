package interviewProblems.Ways_To_Decode;

public class Solution {
    public int numDecodings(String A) {
        return this.decRec(A, A.length() - 1);
    }

    public int decRec(String A, int end){
        if (end < 0){return 1;}
        int sum = 0;
        if (A.charAt(end) > '0'){
            sum = this.decRec(A, end - 1);
        }
        if (this.isValid(A, end)){
            sum += this.decRec(A, end - 2);
        }
        return sum;
    }

    public boolean isValid(String s, int i){
        if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))){
            return true;
        }
        return false;
    }
}
