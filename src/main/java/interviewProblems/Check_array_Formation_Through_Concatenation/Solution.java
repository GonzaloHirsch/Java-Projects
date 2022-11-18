package interviewProblems.Check_array_Formation_Through_Concatenation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // Fill a map of first piece elem --> piece
        // Given the elements are distinct, max 1 piece starts with that integer
        Map<Integer, int[]> pieceMap = new HashMap<>();
        for (int[] piece : pieces) pieceMap.put(piece[0], piece);
        // Iterate the array and see if the pieces match and the order is matched too
        int i = 0;
        int[] piece;
        while (i < arr.length) {
            // If no piece starts with the current integer, it's not possible
            if (!pieceMap.containsKey(arr[i])) return false;
            // Get the piece and see if the order matches
            piece = pieceMap.get(arr[i]);
            for (int part : piece) if (part != arr[i++]) return false;
        }

        return true;
    }
}