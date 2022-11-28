package interviewProblems.Implement_Queue_Using_Stacks;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> in = new Stack<>(), out = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        this.in.push(x);
    }

    public int pop() {
        if (this.out.isEmpty()) this.inToOut();
        return this.out.pop();
    }

    public int peek() {
        if (this.out.isEmpty()) this.inToOut();
        return this.out.peek();
    }

    public boolean empty() {
        return this.out.isEmpty() && this.in.isEmpty();
    }

    private void inToOut() {
        // Moves all the items from in to out so that the order is reversed
        while (!this.in.isEmpty()) this.out.push(this.in.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
