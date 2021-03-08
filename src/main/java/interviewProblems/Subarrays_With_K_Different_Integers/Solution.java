package interviewProblems.Subarrays_With_K_Different_Integers;

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K - 1);
    }

    public int subarraysWithAtMostKDistinct(int[] A, int K) {
        int count = 0, l = 0, r = 0, ret = 0, n = A.length, num;
        int[] memory = new int[20001];

        while (r < n) {
            // Iterate until run out of array or find more than K
            while (r < n && count <= K) {
                num = A[r];
                if (memory[num] == 0) count++;
                memory[num]++;
                r++;
            }
            // Iterate until we decrease the amount
            while (count == K + 1) {
                ret += (r - l - 1);
                num = A[l];
                if (memory[num] == 1) count--;
                memory[num]--;
                l++;
            }
        }

        int tmp = r - l;
        ret += (tmp * (tmp + 1) / 2);
        return ret;
    }


    /*
    Working solution but running out of time
    public int subarraysWithKDistinct(int[] A, int K) {
        Set<Integer> nums;

        int total = 0, n = A.length;

        for (int i = 0; i < n; i++){
            nums = new HashSet<>();
            for (int j = i; j < n && nums.size() <= K; j++){
                nums.add(A[j]);
                if (nums.size() == K){
                    total++;
                }
            }
            // Cuando deja de ser K puedo volver para atras y avanzar con el i
        }

        return total;
    }*/
}
