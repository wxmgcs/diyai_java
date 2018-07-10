package cn.diyai.java_base.thread_connection.stack1;


public class Test {

    public static void main(String[] args) {
        try{
            MyStack myStack = new MyStack();
            P p = new P(myStack);
            C c = new C(myStack);
            P_Thread pThread = new P_Thread(p);
            C_Thread cThread = new C_Thread(c);
            pThread.start();
            cThread.start();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
