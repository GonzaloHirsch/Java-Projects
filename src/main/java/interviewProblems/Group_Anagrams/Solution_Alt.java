package interviewProblems.Group_Anagrams;

import java.util.*;

class MinStack {
    private Map<Integer, Integer> stack = new HashMap<>();
    private int index = 0;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        this.min = Math.min(this.min, val);
        this.stack.put(this.index++, val);
    }

    public void pop() {
        this.stack.remove(--this.index);
        this.min = Integer.MAX_VALUE;
        this.stack.values().forEach(val -> {
            this.min = Math.min(val, min);
        });
    }

    public int top() {
        return this.stack.get(index - 1);
    }

    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */