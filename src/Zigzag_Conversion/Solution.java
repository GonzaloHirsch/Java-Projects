package Zigzag_Conversion;

public class Solution {
    public String convert(String s, int numRows) {
        String[] arr = new String[numRows];
        for (int i = 0; i < numRows; i++){arr[i] = "";}
        int diagCount = 0;
        int vertCount = 0;
        boolean vertical = true;
        for (int i = 0; i < s.length(); i++){
            if (vertical || numRows <= 2){
                arr[vertCount++] += s.charAt(i);
                if (vertCount >= numRows){
                    vertCount = 0;
                    vertical = false;
                }
            } else {
                diagCount++;
                arr[numRows - diagCount - 1] += s.charAt(i);
                if (diagCount >= numRows - 2){
                    diagCount = 0;
                    vertical = true;
                }
            }
        }
        String sol = "";
        for (String str : arr){
            if (str != null){
                sol += str;
            }
        }
        return sol;
    }
}