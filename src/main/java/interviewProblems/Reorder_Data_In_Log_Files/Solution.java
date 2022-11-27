package interviewProblems.Reorder_Data_In_Log_Files;

import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        TreeMap<String[], Integer> treeMap = new TreeMap<>((a, b) -> {
            if (a[1].equals(b[1])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });

        // Fill the collections
        for (int i = 0; i < logs.length; i++) {
            if (this.isDigitLog(logs[i])) digitLogs.add(logs[i]);
            else treeMap.put(this.splitLog(logs[i]), i);
        }

        String[] result = new String[logs.length];
        int i = 0;
        // Add all the letter logs
        for (Map.Entry<String[], Integer> entry : treeMap.entrySet()) result[i++] = logs[entry.getValue()];
        // Add all the digit logs
        for (String digitLog : digitLogs) result[i++] = digitLog;
        return result;
    }

    private boolean isDigitLog(String log) {
        int spaceIndex = log.indexOf(" ");
        char c = log.charAt(spaceIndex + 1);
        return c >= '0' && c <= '9';
    }

    private String[] splitLog(String log) {
        int spaceIndex = log.indexOf(" ");
        return new String[]{
                log.substring(0, spaceIndex),
                log.substring(spaceIndex + 1)
        };
    }
}
