package cn.diyai.java_base.multhread;

public class MyThreadStatus extends  Thread{
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run(){
        while(true){
            i++;
        }
    }
}
