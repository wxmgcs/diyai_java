package cn.diyai.java_base.thread_state.stateTest3;

public class MyService {
    synchronized static public void serviceMethod(){
        try{
            System.out.println(Thread.currentThread().getName()+"进入业务方法");
            Thread.sleep(10*1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
