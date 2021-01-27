package interviewProblems.String_K_Compression;

public class Solution {
    public int solution(String S, int K){
        int n = S.length(), min =  n, curr;

        for(int i = 0; i < n - (K - 1); i++){
            curr = this.compress(this.avoidPart(S, i, i + K, n));
            if (curr < min){
                min = curr;
            }
        }
        return min;
    }

    public int compress(String S){
        int n = S.length(), total = 0, count = 0;
        char curr;
        Character prev = null;

        for (int i = 0; i < n; i++){
            curr = S.charAt(i);
            if (prev == null){
                count++;
            } else {
                if (curr == prev){
                    count++;
                } else {
                    // Number length + letter
                    total += this.getLength(count) + 1;
                    count = 1;
                }
            }
            prev = curr;
        }

        return total + this.getLength(count) + 1;
    }

    public String avoidPart(String S, int a, int b, int n){
        if (a == 0){
            return S.substring(b, n);
        } else if (b == n){
            return S.substring(0, a);
        } else {
            return S.substring(0, a) + S.substring(b, n);
        }
    }

    public int getLength(int n){
        if (n == 1){
            return 0;
        }
        int count = 1;
        while (n / 10 >= 1){
            count++;
            n /= 10;
        }
        return count;
    }
}
