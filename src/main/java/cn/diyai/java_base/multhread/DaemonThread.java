package cn.diyai.java_base.multhread;

public class DaemonThread extends  Thread{
    private int i =0;
    @Override
    public void run(){
        while(true){
            i++;
            System.out.println(i);
            try {
                Thread.sleep(1*1000);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }
}
