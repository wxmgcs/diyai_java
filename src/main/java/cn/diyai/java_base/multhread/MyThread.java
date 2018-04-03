package cn.diyai.java_base.multhread;

public class MyThread extends  Thread{


    private int i;
    SynchronizedObject object;

    public MyThread (int i){
        super();
        this.i = i;
    }

    public MyThread(SynchronizedObject object){
        super();
        this.object = object;
    }

    @Override
    public void run(){
        super.run();

//        try{
//            for(int i = 0;i < 10;i++){
//                int time = (int)Math.random() * 1000;
//
//                Thread.sleep(time);
//                System.out.println("run="+Thread.currentThread().getName());
//
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }

        object.printString("b","BB");





    }
}
