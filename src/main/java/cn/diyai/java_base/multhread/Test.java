package cn.diyai.java_base.multhread;

public class Test {

    public static void main(String[] args) {
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

//        Runnable runnable = new MyRunnable();
//        Thread thread = new Thread(runnable);
//        thread.start();
//        try{
//            Thread.sleep(8000);
//        }catch (Exception ex){
//
//        }
//        thread.stop();
//
//        System.out.println("over");

        // test4
//        try{
//            SynchronizedObject object = new SynchronizedObject();
//            MyThread  thread = new MyThread(object);
//            thread.start();
//            Thread.sleep(500);
//            thread.stop();
//            System.out.println(object.toString());
//
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }


        //test5
        //testThreadStatus();
        //testThreadPriority();
        testDaemon();


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
        public static void testThreadStatus(){
        // 测试线程的状态
        try{

            MyThreadStatus thread = new MyThreadStatus();
            thread.start();
            Thread.sleep(5000);

            thread.suspend();
            System.out.println("A ="+System.currentTimeMillis()+" i="+thread.getI());

            Thread.sleep(5000);
            System.out.println("A ="+System.currentTimeMillis()+" i="+thread.getI());

            thread.resume();

            Thread.sleep(5000);

            thread.suspend();

            System.out.println("B ="+System.currentTimeMillis()+" i="+thread.getI());

            Thread.sleep(5000);

            System.out.println("B ="+System.currentTimeMillis()+" i="+thread.getI());


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void testThreadPriority(){
        System.out.println("main thread begin priority = "+Thread.currentThread().getPriority());
        //Thread.currentThread().setPriority(6);
        System.out.println("main thread begin priority = "+Thread.currentThread().getPriority());


        for(int i = 0; i < 5;i++){
            ThreadPriority  thread = new ThreadPriority();
            thread.setPriority(10);
            thread.start();

            ThreadPriority2  thread2 = new ThreadPriority2();
            thread2.setPriority(1);
            thread2.start();
        }



    }

    public static void testDaemon(){
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
        sleep(5);
        logger("我離開thread對象也不再打印了，也就是停止了");
    }

    public static void sleep(int millis){
        try{
            Thread.sleep(millis*1000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void logger(String msg){
        System.out.println(msg);
    }
}
