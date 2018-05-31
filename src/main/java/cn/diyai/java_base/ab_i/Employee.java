package cn.diyai.java_base.ab_i;

/**
 * Created by diyai on 2018/5/31.
 */
public abstract class Employee {
    private String name;

    public String getAddress() {
        return address;
    }

    public abstract void travel();

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Employee(){
        this.name = "employee";
    }

    public Employee(String name,String address){
        this.name = name;
        this.address = address;
    }

}
