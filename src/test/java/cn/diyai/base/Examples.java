package cn.diyai.base;

import junit.framework.Assert;

public class Examples {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main(String[] args) {
        Examples ex = new Examples();
        ex.change(ex.str, ex.ch);

        Assert.assertEquals("goodandgbc",ex.str +"and"+new String(ex.ch));
    }

    public void change(String str, char ch[]){
        str= "test ok";
        ch[0]= 'g';
    }
}
