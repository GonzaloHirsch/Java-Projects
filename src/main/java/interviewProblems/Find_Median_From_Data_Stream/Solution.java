package interviewProblems.Find_Median_From_Data_Stream;


import java.util.*;

class Solution {
    class MedianFinder {
        private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        private PriorityQueue<Integer> large = new PriorityQueue<>();
        private boolean even = true;

        public MedianFinder() {}

        public void addNum(int num) {
            if (this.even) {
                this.large.offer(num);
                this.small.offer(this.large.poll());
            } else {
                this.small.offer(num);
                this.large.offer(this.small.poll());
            }
            this.even = !this.even;
        }

        public double findMedian() {
            if (this.even) return (this.small.peek() + (double)this.large.peek())/2;
            else return this.small.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}