package cn.diyai.java_base.thread_connection.p_r_test;


public class C {

    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    lock.wait();
                }

                System.out.println("消费数据:"+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
