package interviewProblems.Battleships_In_A_Board;

import java.util.Arrays;

class Solution {
    public int countBattleships(char[][] board) {
        int total = 0, consecutive = 0;
        // Counts how many consecutive were there
        int[] row = new int[board[0].length];

        for (int i = 0; i < board.length; i++) {
            consecutive = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    consecutive++;
                    // We have a ship to be consecutive for
                    if (consecutive > 1) {
                        // Go setting the row as 0 because it cannot be vertical
                        row[Math.max(0, j - 1)] = 0;
                        row[j] = 0;
                        // If I'm in the last col, I have to account for that
                        if (j == board[0].length - 1) total++;
                    } else {
                        // Count vertical places
                        row[j]++;
                        // If in the last row and the boat ends there, account for that
                        if (i == board.length - 1 && row[j] > 1) {
                            total++;
                            consecutive = 0;
                        }
                        // Edge case last row & col but only 1
                        else if (j == board[0].length - 1 && i == board.length - 1 && row[j] == 1) total++;
                    }
                } else {
                    // Check if the previous column was something
                    if (row[j] > 0) total++;
                    // If in the last row and only 1 consecutive, won't have next row to take care of that
                    if (consecutive == 1 && i == board.length - 1) total++;
                    row[j] = 0;
                    // Check if we had consecutive in horizontal
                    if (consecutive > 1) total++;
                    consecutive = 0;
                }
            }
        }

        return total;
    }
}
