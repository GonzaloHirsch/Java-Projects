package Missing_Integer;
import java.util.HashSet;

public class Solution {
    public int solution(int[] A) {
        // Building the hashset for quick access
        HashSet<Integer> a = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++){
            a.add(A[i]);
        }

        // Variable for the minimum number that may not be present
        int min = 1;

        // Iterates while the hashset does not contain the maybe number
        while (a.contains(min)){
            min++;
        }

        return min;
    }
}
