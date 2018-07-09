package cn.diyai.java_base.thread_connection.p_c_allWait;


public class C {

    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock){
                while(ValueObject.value.equals("")){
                    System.out.println("消费者 "+Thread.currentThread().getName()+ " waiting ");
                    lock.wait();
                }

                System.out.println("消费者 "+Thread.currentThread().getName()+ " runnable ");
                System.out.println("消费者:"+ ValueObject.value);
                ValueObject.value = "";
                //如果此处改成lock.notify()会出现假死
                lock.notifyAll();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
