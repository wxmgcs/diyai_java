package cn.diyai.java_base.concurrent;

public class Actor extends  Thread{
    @Override
    public void run() {
        System.out.println(getName()+" 是一个演员");

        int n = 0;
        System.out.println(getName()+" 演出的次数:"+(++n));




        System.out.println(getName()+" 的演出结束了 ");
    }

    public static void main(String[] args){
        Thread actor = new Actor();
        actor.setName("Mr thread");
        actor.start();
    }
}
