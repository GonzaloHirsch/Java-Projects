package interviewProblems.Snapshot_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class SnapshotArray {
    private final Map<Integer, Map<Integer, Integer>> history;
    private final Map<Integer, Integer> curr;
    private int snap = 0;

    public SnapshotArray(int length) {
        this.history = new HashMap<>();
        this.curr = new HashMap<>();
    }

    public void set(int index, int val) {
        this.curr.put(index, val);
    }

    public int snap() {
        this.createSnap();
        return this.snap++;
    }

    private void createSnap() {
        this.history.put(this.snap, new HashMap<>(this.curr));
    }

    public int get(int index, int snap_id) {
        return this.history.get(snap_id).getOrDefault(index, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

