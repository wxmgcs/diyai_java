package cn.diyai.java_base.multhread;

public class SelfPrivateThreadA extends  Thread{
    private HasSelfPrivateNum numRef;

    public SelfPrivateThreadA(HasSelfPrivateNum numRef){
        super();
        this.numRef =  numRef;
    }

    @Override
    public void run(){
        numRef.addI("a");

    }
}
