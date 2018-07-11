package cn.diyai.java_base.thread_state.stateTest3;

public class MyThread1 extends Thread{


    @Override
    public void run() {

        MyService.serviceMethod();
    }
}
