package cn.diyai.java_base.synchronizedemo;
import org.junit.Test;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeSample {

    public int sharedState1;
    public int sharedState2;
    public int sharedState3;

    public void nonSafeAction() {
        while (sharedState1 < 100000) {
            int former = sharedState1++;
            int latter = sharedState1;
            if (former != latter - 1) {
                System.out.println("[nonSafeAction] Observd data race,former is " + former + "" +
                        ", latter is " + latter);
            }
        }
    }

    public void safeAction() {
        while (sharedState2 < 100000) {
            //将两次赋值过程用 synchronized 保护起来，使用 this 作为互斥单元，
            // 就可以避免别的线程并发的去修改 sharedState
            synchronized (this) {
                int former = sharedState2++;
                int latter = sharedState2;
                if (former != latter - 1) {
                    System.out.println("[safeAction] Observd data race,former is " + former + "" +
                            ", latter is " + latter);
                }
            }
        }
    }

    public void safeAction2() {
        //创建公平锁
        ReentrantLock fairLock = new ReentrantLock(true);
        if(fairLock.tryLock()){
            try {
                while (sharedState3 < 100000) {
                    synchronized (this) {
                        int former = sharedState3++;
                        int latter = sharedState3;
                        if (former != latter - 1) {
                            System.out.println("[safeAction] Observd data race,former is " + former + "" +
                                    ", latter is " + latter);
                        }
                    }
                }
            } finally {
                fairLock.unlock();
            }
        }
    }


    @Test
    public void testNonSafeAction() throws  Exception{
        final ThreadSafeSample threadSafeSample = new ThreadSafeSample();
        Thread threadA = new Thread() {
            public void run() {
                threadSafeSample.nonSafeAction();
            }
        };

        Thread threadB = new Thread() {
            public void run() {
                threadSafeSample.nonSafeAction();
            }
        };

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }

    @Test
    public void testSafeAction() throws  Exception{
        final ThreadSafeSample threadSafeSample = new ThreadSafeSample();
        Thread threadA = new Thread() {
            public void run() {
                threadSafeSample.safeAction();
            }
        };

        Thread threadB = new Thread() {
            public void run() {
                threadSafeSample.safeAction();
            }
        };

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }

    @Test
    public void testSafeAction2() throws  Exception{
        final ThreadSafeSample threadSafeSample = new ThreadSafeSample();
        Thread threadA = new Thread() {
            public void run() {
                threadSafeSample.safeAction2();
            }
        };

        Thread threadB = new Thread() {
            public void run() {
                threadSafeSample.safeAction2();
            }
        };

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}
