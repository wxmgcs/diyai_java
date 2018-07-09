package cn.diyai.java_base.thread_connection;

public class MyThread1 extends Thread{

    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try{

            synchronized (lock){
                System.out.println("开始   waiting time="+System.currentTimeMillis());
                lock.wait();
                System.out.println("结束   waiting time="+System.currentTimeMillis());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
