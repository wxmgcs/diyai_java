package cn.diyai.base;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BaseTest extends TestCase{

    public void test(){
        Float  s=new  Float(0.1f);
        Float  t=new  Float(0.1f);
        Double  u=new  Double(0.1);
        Assert.assertEquals( s==t,false);
        Assert.assertEquals( s.equals(t),true);
        Assert.assertEquals( u.equals(s),false);
        Assert.assertEquals( t.equals(u),false);

    }

}
