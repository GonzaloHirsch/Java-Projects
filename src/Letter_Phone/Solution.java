package Letter_Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> sol = new ArrayList<String>();
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('0', Arrays.asList('0'));
        map.put('1', Arrays.asList('1'));
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        combine(sol, map, "", A, 0);
        return sol;
    }

    public void combine(ArrayList<String> sol, HashMap<Character, List<Character>> map, String partial, String A, int index){
        if (index == A.length()){
            sol.add(partial);
        } else {
            for (int i = 0; i < map.get(A.charAt(index)).size(); i++){
                partial += map.get(A.charAt(index)).get(i);
                this.combine(sol, map, partial, A, index + 1);
                partial = partial.substring(0, partial.length() - 1);
            }
        }
    }
}