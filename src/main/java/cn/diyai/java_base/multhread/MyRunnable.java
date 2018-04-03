package cn.diyai.java_base.multhread;

public class MyRunnable  implements  Runnable{

    @Override
    public void run(){
        try{
            Thread.sleep(20000);
        }catch (Exception ex){

        }
        System.out.println("run...");
    }
}
