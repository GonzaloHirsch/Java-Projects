package interviewProblems.Word_Search;
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for (int x = 0, y; x < board.length; x++) for (y = 0; y < board[0].length; y++) if (findWord(board, wordArr, 0, x, y)) return true;
        return false;
    }

    private boolean findWord(char[][] board, char[] word, int w, int x, int y) {
        char c = board[x][y];
        if (w == word.length - 1 && c == word[w]) return true;
        if (c == 0 || c != word[w]) return false;
        // Branch out
        boolean found = false;
        board[x][y] = 0;
        if (x > 0) found = findWord(board, word, w + 1, x - 1, y);
        if (y > 0) found |= findWord(board, word, w + 1, x, y - 1);
        if (x < board.length - 1) found |= findWord(board, word, w + 1, x + 1, y);
        if (y < board[0].length - 1) found |= findWord(board, word, w + 1, x, y + 1);
        board[x][y] = c;
        return found;
    }
}