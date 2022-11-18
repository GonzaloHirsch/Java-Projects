package interviewProblems.Design_Circular_Deque;

class Solution {
    class MyCircularDeque {
        private int[] arr;
        private int start, end, size, limit;

        public MyCircularDeque(int k) {
            this.size = 0;
            this.limit = k;
            this.start = 0;
            this.end = k - 1;
            this.arr = new int[k];
        }

        public boolean insertFront(int value) {
            if (this.isFull()) return false;
            this.arr[this.start] = value;
            this.start = (this.start + 1) % this.limit;
            this.size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (this.isFull()) return false;
            this.arr[this.end] = value;
            this.end = (this.end - 1 + this.limit) % this.limit;
            this.size++;
            return true;
        }

        public boolean deleteFront() {
            if (this.isEmpty()) return false;
            this.start = (this.start - 1 + this.limit) % this.limit;
            this.arr[this.start] = 0;
            this.size--;
            return true;
        }

        public boolean deleteLast() {
            if (this.isEmpty()) return false;
            this.end = (this.end + 1) % this.limit;
            this.arr[this.end] = 0;
            this.size--;
            return true;
        }

        public int getFront() {
            if (this.isEmpty()) return -1;
            return this.arr[(this.start - 1 + this.limit) % this.limit];
        }

        public int getRear() {
            if (this.isEmpty()) return -1;
            return this.arr[(this.end + 1) % this.limit];
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.limit;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}