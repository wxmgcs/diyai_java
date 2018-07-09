package cn.diyai.java_base.thread_connection.p_c_allWait;

public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {

        while(true){
            p.setValue();
        }
    }
}
