package interviewProblems.Substring_Concatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String b : B){
            int val = 1;
            if (map.containsKey(b)){
                val += map.get(b);
            }
            map.put(b, val);
        }
        ArrayList<Integer> sol = new ArrayList<>();
        int totalLen = B.size() * B.get(0).length();
        int wordLen = B.get(0).length();
        for(int i = 0; i < A.length() - totalLen + 1; i++){
            String sub = A.substring(i, i + totalLen);
            HashMap<String, Integer> curr = new HashMap<>();
            for(int j = i ; j < i + totalLen; j += wordLen){
                String word = A.substring(j, j + wordLen);
                int val=1;
                if(curr.containsKey(word)){
                    val += curr.get(word);
                }
                curr.put(word, val);
            }
            if(map.equals(curr)){
                sol.add(i);
            }
        }
        return sol;
    }

}
