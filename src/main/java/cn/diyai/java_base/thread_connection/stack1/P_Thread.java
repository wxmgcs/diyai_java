package cn.diyai.java_base.thread_connection.stack1;

/**
 * Created by diyai on 2018/7/10.
 */
public class P_Thread extends  Thread{

    private P p;

    public P_Thread(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while(true){
            p.pushService();
        }
    }
}
