package cn.diyai.java_base.thread_state.stateTest3;

import cn.diyai.java_base.thread_state.stateTest2.MyThread;

public class Test {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setName("a");
            thread.start();
            System.out.println("main方法中的thread2:"+thread.getState());

            MyThread2 thread2 = new MyThread2();
            thread2.setName("b");
            thread2.start();
            System.out.println("main方法中的thread2:"+thread2.getState());


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
