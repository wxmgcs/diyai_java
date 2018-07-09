package cn.diyai.java_base.thread_connection.p_r_test;

public class ThreadC extends Thread{
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
            c.getValue();
        }
    }

}
