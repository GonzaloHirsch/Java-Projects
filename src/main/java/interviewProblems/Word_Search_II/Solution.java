package interviewProblems.Word_Search_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> result;
    private char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = this.buildTrie(words);
        this.result = new ArrayList<>();
        this.board = board;
        for (int x = 0; x < board.length; x++) for (int y = 0; y < board[0].length; y++) this.findWord(x, y, root);
        return result;
    }

    private void findWord(int x, int y, TrieNode curr) {
        char c = board[x][y];
        // No more space to advance or the character is not in the Trie
        if (c == 0 || curr.children[c - 'a'] == null) return;
        curr = curr.children[c - 'a'];
        // Check if word is found, remove it from Trie so that it doens't appear as duplicate
        if (curr.word != null) {
            this.result.add(curr.word);
            curr.word = null;
        }
        // Branch out, check conditions to avoid extra calls
        board[x][y] = 0;
        if (x > 0) this.findWord(x - 1, y, curr);
        if (y > 0) this.findWord(x, y - 1, curr);
        if (x < board.length - 1) this.findWord(x + 1, y, curr);
        if (y < board[0].length - 1) this.findWord(x, y + 1, curr);
        board[x][y] = c;
    }

    // Builds a prefix tree and returns the root
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode(), curr;
        int i;
        for (String word : words) {
            curr = root;
            for (char c : word.toCharArray()) {
                i = c - 'a';
                if (curr.children[i] == null) curr.children[i] = new TrieNode();
                curr = curr.children[i];
            }
            curr.word = word;
        }
        return root;
    }

    // Trie node will have uninitialized node children and the word itself
    private class TrieNode {
        public TrieNode[] children = new TrieNode['z' - 'a' + 1];
        public String word;
    }
}