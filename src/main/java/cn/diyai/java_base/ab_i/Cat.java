package cn.diyai.java_base.ab_i;

/**
 * Created by diyai on 2018/5/31.
 */
public class Cat implements Animal {

    @Override
    public void eat(String someThing) {
        System.out.println("Cat eat "+someThing);
    }

    @Override
    public void sleep(int hour) {
        System.out.println("Cat sleep for "+hour + " hour");
    }

    public static void  main(String[] args){
        Cat cat = new Cat();
        cat.eat("fish");
        cat.sleep(5);

    }
}
