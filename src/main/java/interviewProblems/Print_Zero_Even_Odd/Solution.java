package interviewProblems.Print_Zero_Even_Odd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class Solution {
    private int n;
    private int nextNumber = 1;
    private boolean canPrintZero = true;
    private ReentrantLock lock;
    private Condition evenCondition;
    private Condition oddCondition;
    private Condition zeroCondition;


    public Solution(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.evenCondition = lock.newCondition();
        this.oddCondition = lock.newCondition();
        this.zeroCondition = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < this.n; i++) {
            lock.lock();
            try {
                while (!this.canPrintZero) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                this.canPrintZero = false;
                if (this.nextNumber % 2 == 1) {
                    oddCondition.signalAll();
                } else {
                    evenCondition.signalAll();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < this.n / 2; i++) {
            lock.lock();
            try {
                while (this.nextNumber % 2 != 0 || this.canPrintZero) {
                    evenCondition.await();
                }
                printNumber.accept(this.nextNumber);
                this.nextNumber++;
                this.canPrintZero = true;
                zeroCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < Math.ceil(this.n / 2.0); i++) {
            lock.lock();
            try {
                while (this.nextNumber % 2 != 1 || this.canPrintZero) {
                    oddCondition.await();
                }
                printNumber.accept(this.nextNumber);
                this.nextNumber++;
                this.canPrintZero = true;
                zeroCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}