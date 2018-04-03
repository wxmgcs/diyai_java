package cn.diyai.java_base.multhread;

public class SelfPrivateThreadB extends  Thread{
    private HasSelfPrivateNum numRef;

    public SelfPrivateThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef =  numRef;
    }

    @Override
    public void run(){
        numRef.addI("b");

    }
}
