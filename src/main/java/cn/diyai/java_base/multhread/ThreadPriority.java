package cn.diyai.java_base.multhread;

import cn.diyai.datastructures.Random;

public class ThreadPriority extends Thread {

    @Override
    public void run() {
        System.out.println(" threadpriority = " + this.getPriority());

//        ThreadPriority2  thread = new ThreadPriority2();
//        thread.start();
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.randomInt();
                addResult = addResult + i;

            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("##### thread priority use time=" + (endTime - beginTime));
    }


}
