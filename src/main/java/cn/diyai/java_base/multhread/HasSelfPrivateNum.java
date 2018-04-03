package cn.diyai.java_base.multhread;

public class HasSelfPrivateNum {

    public void addI(String userName){
        // 如果 num变量设置为全局的就会出现线程不安全问题
        int num = 0;
        try{
            if(userName.equals("a")){
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set over");
            }

            System.out.println(userName+" num= "+num);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
