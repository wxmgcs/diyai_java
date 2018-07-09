package cn.diyai.java_base.thread_connection.p_r_test;

public class Test {

    public static void main(String[] args) {
        try{

            String lock = new String("");
            P p = new P(lock);
            C c = new C(lock);

            ThreadP pThread = new ThreadP(p);
            ThreadC cThread = new ThreadC(c);

            pThread.start();
            cThread.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
