package cn.diyai.java_base.thread_connection.p_r_test;

public class P {

    private String lock;
    private String queue;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue(){
        try{
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }

                String value = System.currentTimeMillis()+ "_"+System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
