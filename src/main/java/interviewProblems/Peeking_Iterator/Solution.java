package interviewProblems.Peeking_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
        Queue<Integer> q = new LinkedList<>();

        public PeekingIterator(Iterator<Integer> iterator) {
            while (iterator.hasNext()) q.add(iterator.next());
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return q.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return q.poll();
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }
}