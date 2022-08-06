package interviewProblems.Print_Zero_Even_Odd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class Solution_Alternative {
    private int n;
    private int flag = -1;
    private ReentrantLock lock;
    private Condition writeCondition;


    public Solution_Alternative(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.writeCondition = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < this.n; i++) {
            lock.lock();
            try {
                while (this.flag != -1) {
                    writeCondition.await();
                }
                printNumber.accept(0);
                this.flag = i % 2;
                writeCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int limit = this.n / 2;
        for (int i = 0; i < limit; i++) {
            lock.lock();
            try {
                while (this.flag != 1) {
                    writeCondition.await();
                }
                printNumber.accept(2 * (i + 1));
                this.flag = -1;
                writeCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int limit = (int)Math.ceil(this.n / 2.0);
        for (int i = 0; i < limit; i++) {
            lock.lock();
            try {
                while (this.flag != 0) {
                    writeCondition.await();
                }
                printNumber.accept((2 * i) + 1);
                this.flag = -1;
                writeCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}