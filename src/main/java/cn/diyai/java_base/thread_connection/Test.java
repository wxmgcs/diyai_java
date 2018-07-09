package cn.diyai.java_base.thread_connection;

import cn.diyai.java_base.multhread.MyThread;

public class Test {

    public static void main(String[] args) {
        try{

            Object lock = new Object();
            MyThread1 t1 = new MyThread1(lock);
            t1.start();

            Thread.sleep(3*1000);

            MyThread2 t2 = new MyThread2(lock);
            t2.start();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
