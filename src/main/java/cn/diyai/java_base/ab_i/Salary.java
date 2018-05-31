package cn.diyai.java_base.ab_i;

/**
 * Created by diyai on 2018/5/31.
 */
public class Salary extends Employee {

    private String name;
    public Salary(String name,String adderss){
        super(name,adderss);
        this.name = name;
    }

    public void travel(){
        System.out.println(this.name+" is traving");
    }
}
