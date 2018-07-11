package cn.diyai.java_base.thread_state.stateTest3;

public class MyThread2 extends Thread{


    @Override
    public void run() {

        MyService.serviceMethod();
    }
}
