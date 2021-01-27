package interviewProblems.Character_Precedence;

import java.util.*;

public class Solution {
    public String findWord(List<String> precedences){
        Character mostPrecedent, current;

        Map<Character, Character> precedenceMap = new HashMap<>();
        Set<Character> characterSet = new HashSet<>();

        // Populating map
        String[] splitString;
        for (String s : precedences){
            splitString = s.split(">");
            precedenceMap.put(splitString[0].charAt(0), splitString[1].charAt(0));
            characterSet.add(splitString[1].charAt(0));
        }

        // Finding most precedent
        Optional<Character> maybeCharacter = precedenceMap.keySet().stream().filter(k -> !characterSet.contains(k)).findFirst();
        mostPrecedent = maybeCharacter.get();

        StringBuilder sb = new StringBuilder();
        sb.append(mostPrecedent);

        // Building the word
        current = mostPrecedent;
        while (precedenceMap.containsKey(current)){
            sb.append(precedenceMap.get(current));
            current = precedenceMap.get(current);
        }

        return sb.toString();
    }
}
