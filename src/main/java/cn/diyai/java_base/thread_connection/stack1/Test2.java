package cn.diyai.java_base.thread_connection.stack1;


//多个线程
public class Test2 {

    public static void main(String[] args) {
        try{

            for(int i = 0; i < 10; i++){
                MyStack myStack = new MyStack();
                P p = new P(myStack);
                C c = new C(myStack);
                P_Thread pThread = new P_Thread(p);
                C_Thread cThread = new C_Thread(c);
                pThread.start();
                cThread.start();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
