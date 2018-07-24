package cn.diyai.java_base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("cn.diyai.java_base.reflection.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }

        Person per1=null;
        Person per2=null;
        Person per3=null;
        Person per4=null;
        //取得全部的public 方法
        for(Method method: demo.getMethods()){
            System.out.println(method);
        }
        try{
            //获取该类的构造器
            Constructor<?> cons[]=demo.getConstructors();

            for(Constructor con : cons){
                System.out.println("constructor: "+con);
            }

            per1=(Person)cons[2].newInstance("patrick");

            System.out.println(per1.getName());
        }catch (Exception ex){
            ex.printStackTrace();
        }

//        try{
//            per1=(Person)cons[0].newInstance();
//            per2=(Person)cons[1].newInstance("Rollen",20,false);
////            per3=(Person)cons[2].newInstance(20);
////            per4=(Person)cons[3].newInstance("Rollen",20);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        System.out.println(per1);
//        System.out.println(per2);
//        System.out.println(per3);


    }
}
