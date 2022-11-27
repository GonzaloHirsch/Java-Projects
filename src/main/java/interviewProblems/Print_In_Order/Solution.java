package interviewProblems.Print_In_Order;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    class Foo {
        final Lock lock = new ReentrantLock();
        final Condition firstDone  = lock.newCondition();
        final Condition secondDone = lock.newCondition();
        int curr;

        public Foo() {
            this.curr = 1;
        }

        public void first(Runnable printFirst) throws InterruptedException {
            this.lock.lock();
            try {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                this.curr = 2;
                this.firstDone.signal();
            } finally {
                this.lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            this.lock.lock();
            try {
                while (this.curr != 2) this.firstDone.await();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                this.curr = 3;
                this.secondDone.signal();
            } finally {
                this.lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            this.lock.lock();
            try {
                while (this.curr != 3) this.secondDone.await();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                this.secondDone.signal();
            } finally {
                this.lock.unlock();
            }
        }
    }
}
