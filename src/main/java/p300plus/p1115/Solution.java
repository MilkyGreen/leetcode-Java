package p300plus.p1115;

public class Solution {
    private int n;

    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    volatile String lastPrinted = "bar";

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            if("foo".equals(lastPrinted)){
                c1.await();
            }
            printFoo.run();
            lastPrinted = "foo";
            c2.signalAll();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            if("bar".equals(lastPrinted)){
               c2.await();
            }
            printBar.run();
            lastPrinted = "bar";
            c1.signalAll();
            lock.unlock();
        }
    }
}
