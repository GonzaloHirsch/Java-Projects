package interviewProblems.Flatten_Nested_List_Iterator;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Iterator<NestedInteger> iter;
    private Deque<Iterator<NestedInteger>> pending;
    private int size;
    private Integer _next;
    private NestedInteger item;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.iter = nestedList.listIterator();
        this.pending = new LinkedList<>();
        this.size = nestedList.size();
        this._next = this.__next(); // Precomputes the next value for the first time
    }

    // We need to know ahead of time what is the next value if there is one because of the [[]] case
    @Override
    public Integer next() {
        // Temp store the next value
        Integer res = this._next;
        // Compute the next value to be available
        this._next = this.__next();
        return res;
    }

    private Integer __next() {
        if (!this.hasInnerNext()) return null;
        // Dive into the list
        // Check the current iterator hash a next element;
        while (this.iter.hasNext()) {
            item = this.iter.next();
            // Take into account removing a value
            this.size--;
            // If the item is an integer, just return it because it's the next one
            if (item.isInteger()) return item.getInteger();
                // In this case it's a list
            else {
                // Add the iterator to the pending list
                this.pending.push(this.iter);
                // Get the next iterator
                this.iter = item.getList().listIterator();
                // Account for new items
                this.size += item.getList().size();
            }
        }
        // We return the value of the has next but popping an iterator from the stack
        this.iter = this.pending.size() > 0 ? this.pending.pop() : null;
        return this.__next();
    }

    // Use the total size, which takes into account empty lists
    private boolean hasInnerNext() {
        return this.size > 0;
    }

    // It uses the precomputed element to know if there is another value to return
    @Override
    public boolean hasNext() {
        return this._next != null;
    }

    public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

