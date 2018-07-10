package cn.diyai.java_base.thread_connection.stack1;

/**
 * Created by diyai on 2018/7/10.
 */
public class C_Thread extends Thread{

    private C c;

    public C_Thread(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while(true){
            c.popService();
        }
    }
}
