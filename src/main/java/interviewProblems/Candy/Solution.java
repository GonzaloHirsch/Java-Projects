package interviewProblems.Candy;

import java.util.*;

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < n; i++){
            if (ratings[i] > 0){
                map.computeIfAbsent(ratings[i], k -> new ArrayList<Integer>());
                map.get(ratings[i]).add(i);
            }
        }

        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        int me, next, prev, curr;

        List<Integer> positions;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            positions = entry.getValue();
            me = entry.getKey();
            for (Integer pos : positions){
                next = pos + 1;
                prev = pos - 1;
                curr = candy[pos];

                if (next < n){
                    if (me > ratings[next]){
                        if (curr <= candy[next]){
                            curr = candy[next] + 1;
                            candy[pos] = candy[next] + 1;
                        }
                    }
                }
                if (prev >= 0){
                    if (me > ratings[prev]){
                        if (curr <= candy[prev]){
                            candy[pos] = candy[prev] + 1;
                        }
                    }
                }
            }
        }

        int total = 0;
        for (int c : candy){
            total += c;
        }

        return total;
    }
}
