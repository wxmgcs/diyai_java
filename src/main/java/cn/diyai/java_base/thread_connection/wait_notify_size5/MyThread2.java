package cn.diyai.java_base.thread_connection.wait_notify_size5;

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
                for(int i = 0; i< 10; i++){
                    MyList.add();

                    if(MyList.size() == 5){
                        System.out.println("开始    notify time="+System.currentTimeMillis());
                        lock.notify();
                        System.out.println("结束    notify time="+System.currentTimeMillis());
                    }
                    System.out.println("添加了 "+(i+1) +" 个元素");
                    Thread.sleep(1*1000);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
