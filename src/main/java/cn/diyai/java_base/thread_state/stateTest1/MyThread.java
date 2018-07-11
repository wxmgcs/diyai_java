package cn.diyai.java_base.thread_state.stateTest1;

public class MyThread extends Thread{
    public MyThread() {
        System.out.println("构造方法中的状态:"+Thread.currentThread().getState());
    }


    @Override
    public void run() {
        try{
            System.out.println("begin sleep "+Thread.currentThread().getState());
            Thread.sleep(5000);
            System.out.println("end sleep "+Thread.currentThread().getState());
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
