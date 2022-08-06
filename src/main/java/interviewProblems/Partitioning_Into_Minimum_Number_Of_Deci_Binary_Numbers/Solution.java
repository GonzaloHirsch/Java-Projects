package interviewProblems.Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers;
class Solution {
    public int minPartitions(String n) {
        char maxC = '0', c;
        for (int i = 0; i < n.length(); i++) {
            c = n.charAt(i);
            if (c > maxC) maxC = c;
        }
        return maxC - '0';
    }
}