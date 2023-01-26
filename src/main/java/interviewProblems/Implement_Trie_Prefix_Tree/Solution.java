package interviewProblems.Implement_Trie_Prefix_Tree;

class Trie {
    private final TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isTerminal = true;
    }

    public boolean search(String word) {
        TrieNode node = this.nodeSearch(word);
        return node != null && node.isTerminal;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = this.nodeSearch(prefix);
        return node != null;
    }

    private TrieNode nodeSearch(String prefix) {
        TrieNode curr = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    private class TrieNode {
        public TrieNode[] children = new TrieNode['z' - 'a' + 1];
        public boolean isTerminal = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */