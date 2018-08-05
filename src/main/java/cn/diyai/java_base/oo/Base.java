package cn.diyai.java_base.oo;

public class Base {

    private String baseName = "base";

    public Base() {
        //此处父类直接调用了子类的方法
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        public void callName() {
            System.out.println(baseName);
        }
    }

    class Sub2 extends Base{
        private String baseName = "sub2";

        public void callName(){
            System.out.println(baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();//null
        //Base b2 = new Sub2();//编译报错
        Base b3 =  new Sub3();//null
        Base b4 =  new Sub4();//base
    }




}
