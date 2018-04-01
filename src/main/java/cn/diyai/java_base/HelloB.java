package cn.diyai.java_base;

public class HelloB extends HelloA{

    public HelloB()
    {
        System.out.println("B 构造方法");
    }
    {
        System.out.println("B 构造代码块");
    }
    static
    {
        System.out.println("B 静态代码块");
    }
}
