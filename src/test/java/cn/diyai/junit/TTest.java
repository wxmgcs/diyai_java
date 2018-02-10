package cn.diyai.junit;

import junit.framework.TestCase;

/**
 * Created by diyai on 2018/2/10.
 */
public class TTest  extends TestCase {
    public void testHello() {
        T t = new T();
        assertEquals(t.m1(),"hello");


    }

}

