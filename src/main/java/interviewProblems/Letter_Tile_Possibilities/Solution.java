package interviewProblems.Letter_Tile_Possibilities;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private char[] tiles;
    private boolean[] usage;
    private Set<String> seqs;

    public int numTilePossibilities(String tiles) {
        this.seqs = new HashSet<>();
        this.tiles = tiles.toCharArray();
        this.usage = new boolean[this.tiles.length];
        // Call it with empty initial and target of length 1
        this.possibilitiesRec("", 1);
        return this.seqs.size();
    }

    private void possibilitiesRec(String curr, int targetLength) {
        String target;
        for (int i = 0; i < this.tiles.length; i++) {
            // Check if the tile was used or not
            if (!this.usage[i]) {
                target = curr + this.tiles[i];
                // Check if sequence is present, if not, add it and count it
                // Do nothing otherwise
                if (!this.seqs.contains(target)) {
                    this.seqs.add(target);
                }
                // Mark tile as used
                this.usage[i] = true;
                // Expand search to elements of one more length
                this.possibilitiesRec(target, targetLength + 1);
                // Mark tile as not used
                this.usage[i] = false;
            }
        }
    }
}