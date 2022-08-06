package interviewProblems.Remove_Sub_Folders_From_The_Filesystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Adding all the folders to a hashset
        Set<String> directories = new HashSet<>();
        for (int i = 0; i < folder.length; i++) directories.add(folder[i]);
        // Avoid extra computation
        int strLen;
        String str;
        for (int i = 0; i < folder.length; i++) {
            str = folder[i];
            strLen = str.length();
            // Split in incremental parts to check if parent is present
            for (int j = 1; j < strLen; j++) {
                // Check if the parent is contained
                if (str.charAt(j) == '/' && directories.contains(str.substring(0, j))) {
                    directories.remove(str);
                    break;
                }
            }
        }
        return new ArrayList<>(directories);
    }
}