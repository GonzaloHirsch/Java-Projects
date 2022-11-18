package interviewProblems.Design_Circular_Queue;
class MyCircularQueue {
    private int[] data;
    private int start, end, size, limit;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.start = 0;
        this.end = 0;   // End points to the next position to allocate
        this.size = 0;
        this.limit = k;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        this.data[this.end] = value;
        this.size++;
        this.end = (this.end + 1) % this.limit;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) return false;
        this.start = (this.start + 1) % this.limit;
        this.size--;
        return true;
    }

    public int Front() {
        if (this.isEmpty()) return -1;
        return this.data[this.start];
    }

    public int Rear() {
        if (this.isEmpty()) return -1;
        //System.out.println()
        return this.data[(this.end - 1 + this.limit) % this.limit];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.limit;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */