package cn.diyai.java_base.thread_connection.p_c_allWait;

public class P {

    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        try{
            synchronized (lock){
                while(!ValueObject.value.equals("")){
                    System.out.println("生产者 "+Thread.currentThread().getName()+ " waiting ");
                    lock.wait();
                }

                System.out.println("生产者 "+Thread.currentThread().getName()+ " runnable ");
                String value = System.currentTimeMillis()+ "_"+System.nanoTime();
                ValueObject.value = value;
                //如果此处改成lock.notify()会出现假死
                lock.notifyAll();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
