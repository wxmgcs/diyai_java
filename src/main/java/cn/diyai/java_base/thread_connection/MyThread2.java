package cn.diyai.java_base.thread_connection;

public class MyThread2 extends Thread{

    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try{

            synchronized (lock){
                System.out.println("开始    notify time="+System.currentTimeMillis());
                lock.notify();
                System.out.println("结束    notify time="+System.currentTimeMillis());
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
