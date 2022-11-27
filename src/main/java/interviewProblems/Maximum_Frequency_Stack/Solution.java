package interviewProblems.Maximum_Frequency_Stack;

import java.util.*;

class FreqStack {
    // Maps number to the frequency it has
    private Map<Integer, Integer> freq;
    private TreeMap<Position, Integer> treeMap;
    private int size;

    public FreqStack() {
        this.freq = new HashMap<>();
        this.treeMap = new TreeMap<>((a, b) -> {
            if (a.freq != b.freq) return Integer.compare(b.freq, a.freq);
            return Integer.compare(b.index, a.index);
        });
    }

    public void push(int val) {
        // Get and set the frequency
        int f = this.freq.getOrDefault(val, 0) + 1;
        this.freq.put(val, f);
        // Add the value to the treemap
        this.treeMap.put(new Position(this.size++, f), val);
    }

    public int pop() {
        Map.Entry<Position, Integer> entry = this.treeMap.pollFirstEntry();
        this.freq.put(entry.getValue(), this.freq.get(entry.getValue()) - 1);
        return entry.getValue();
    }

    private class Position {
        public int index;
        public int freq;
        public Position(int index, int freq){
            this.index = index;
            this.freq = freq;
        }
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
