package cn.diyai.java_base.thread_connection.stack1;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by diyai on 2018/7/10.
 */
public class MyStack {

    private List list = new ArrayList();

    synchronized public void push(){
        try{
            if(list.size() == 100){
                this.wait();
            }

            list.add("anything="+Math.random());
            this.notify();
            System.out.println("push="+list.size());

        }catch (Exception ex){

        }
    }

    synchronized public String pop(){
        String returnValue = "";
        try{
            if(list.size() == 0){
                System.out.println("pop操作 "+Thread.currentThread().getName()+" 线程处理wait状态");
                this.wait();
            }

            returnValue = "" +list.get(0);

            list.remove(0);
            this.notify();
            System.out.println("pop= "+list.size());
        }catch (Exception ex){

            ex.printStackTrace();
        }
        return returnValue;

    }
}
