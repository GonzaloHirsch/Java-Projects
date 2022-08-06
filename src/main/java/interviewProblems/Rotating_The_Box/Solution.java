package interviewProblems.Rotating_The_Box;
class Solution {
    private final char STONE = '#';
    private final char OBS = '*';
    private final char EMPTY = '.';

    public char[][] rotateTheBox(char[][] box) {
        // Create the n x m result
        char[][] results = new char[box[0].length][box.length];
        // Copy the original drawing into the resul
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) results[j][box.length - 1 - i] = box[i][j];
        }
        // Iterate each row and move entire groups of stones downward
        // Find groups of stones, move until border or wall is hit
        boolean canFall = false;
        int startStoneIndex = -1, endStoneIndex = -1, emptySpaceIndex = -1;
        for (int col = 0; col < results[0].length; col++) {
            // Reset variables
            startStoneIndex = -1;
            endStoneIndex = -1;
            emptySpaceIndex = -1;
            canFall = false;
            // Iterate rows from bottom to top
            for (int row = results.length - 1; row >= 0; row--) {
                switch(results[row][col]) {
                    case STONE:
                        // Mark where we found this stone
                        startStoneIndex = row;
                        // Check if there is space for the stone to fall
                        if (canFall) {
                            // Find where the stone group ends
                            endStoneIndex = row;
                            for (int rowUp = row - 1; rowUp >= 0 && results[rowUp][col] == STONE; rowUp--) {
                                if (results[rowUp][col] == STONE) endStoneIndex = rowUp;
                            }
                            // Move that stone group down
                            for (int rowDown = startStoneIndex; rowDown >= endStoneIndex; rowDown--) {
                                results[rowDown + (emptySpaceIndex - startStoneIndex)][col] = STONE;
                                results[rowDown][col] = EMPTY;
                            }
                            // Set back the row to the empty space index
                            row = emptySpaceIndex;
                            canFall = false;
                            startStoneIndex = -1;
                            endStoneIndex = -1;
                        }
                        break;
                    case OBS:
                        startStoneIndex = -1;
                        endStoneIndex = -1;
                        emptySpaceIndex = -1;
                        canFall = false;
                        break;
                    case EMPTY:
                        startStoneIndex = -1;
                        endStoneIndex = -1;
                        // This means there was not empty space before
                        if (!canFall) emptySpaceIndex = row;
                        canFall = true;
                        break;
                }
            }
        }
        return results;
    }
}