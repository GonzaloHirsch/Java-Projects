package Square_Root_Of_Integer;

/**
 * Implemented Newton-Raphson numerical method
 */
public class Solution {
    public int sqrt(int A) {
        if (A == 0 || A == 1){return A;}
        double delta = 0.0001;
        double prev = 10;     // Initial guess
        double next = 11;
        double error = Math.abs(prev - next);
        while (error > delta){
            next = prev - (fun(A, prev)/funPrime(prev));
            error = Math.abs(prev - next);
            prev = next;
        }
        return (int)next;
    }

    public double fun(int A, double x){
        return x * x - A;
    }

    public double funPrime(double x){
        return 2 * x;
    }
}
