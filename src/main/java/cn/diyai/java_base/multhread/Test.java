package cn.diyai.java_base.multhread;

public class Test {

    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());


//        new MyThread(1).start();
//        new MyThread(2).start();
//        new MyThread(3).start();
//        new MyThread(4).start();
//        new MyThread(5).start();
//        new MyThread(6).start();
//        new MyThread(7).start();
//        new MyThread(8).start();
//        new MyThread(9).start();
//        new MyThread(10).start();
//        new MyThread(11).start();
//        new MyThread(12).start();
//        new MyThread(13).start();
//        new MyThread(14).start();

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("over");





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

    }
}
