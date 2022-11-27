package interviewProblems.Word_Ladder;


import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> pending = new LinkedList<>();
        pending.add(beginWord);

        Set<String> visited = new HashSet<>(), words = new HashSet<>(wordList);
        visited.add(beginWord);
        if (!words.contains(endWord)) return 0;

        int path = 1, pendingSize = 0;
        String curr, tmp;
        char[] letters;
        while (!pending.isEmpty()) {
            pendingSize = pending.size();
            for (int j = 0; j < pendingSize; j++) {
                curr = pending.poll();
                if (curr.equals(endWord)) return path;
                letters = curr.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    for (char letter = 'a', og = letters[i]; letter <= 'z'; letter++) {
                        letters[i] = letter;
                        tmp = new String(letters);
                        if (words.contains(tmp) && !visited.contains(tmp)) {
                            pending.add(tmp);
                            visited.add(tmp);
                        }
                        letters[i] = og;
                    }
                }
            }
            path++;
        }
        return 0;
    }
}