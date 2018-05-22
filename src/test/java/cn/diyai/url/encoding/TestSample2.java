package cn.diyai.url.encoding;

/**
 * Created by diyai on 2018/5/22.
 */

import junit.framework.Assert;
import junit.framework.TestCase;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by diyai on 2018/5/22.
 */
public class TestSample2 extends TestCase {
    public void test() throws  Exception{
        String str = null;
        //有<符号
        //<u卡贷>根据您的信息，您暂不符合借款条件，故您的借款申请（15000元，12期）审核未通过。如需借款，06月17日后可再次申请【悠融】
        str = "%3cu%bf%a8%b4%fb%3e%b8%f9%be%dd%c4%fa%b5%c4%d0%c5%cf%a2%a3%ac%c4%fa%d4%dd%b2%bb%b7%fb%ba%cf%bd%e8%bf%ee%cc%f5%bc%fe%a3%ac%b9%ca%c4%fa%b5%c4%bd%e8%bf%ee%c9%ea%c7%eb%a3%a815000%d4%aa%a3%ac12%c6%da%a3%a9%c9%f3%ba%cb%ce%b4%cd%a8%b9%fd%a1%a3%c8%e7%d0%e8%bd%e8%bf%ee%a3%ac06%d4%c217%c8%d5%ba%f3%bf%c9%d4%d9%b4%ce%c9%ea%c7%eb%a1%be%d3%c6%c8%da%a1%bf";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));
        str =  "%e4%bd%a0%e5%a5%bd";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str =  "%e4%bd%a0%e5%a5%bd%c4%e3%ba%c3%a1%be%b3%a9%cc%ec%d3%ce%a1%bf";//gbk
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str =  "6502,%e4%bf%9d%e9%99%a9%e7%ae%b1%e5%8f%96%e6%ac%be%e9%aa%8c%e8%af%81%e7%a0%81%e3%80%82%e5%ae%98%e7%bd%91:www.jj.cn%e3%80%90jj%e6%af%94%e8%b5%9b%e3%80%91";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        //qwewrwrr1元手机充值卡已充值到账,请您关注24小时内手机话费账单变化，如有问题请联系在线客服【jj比赛】
        str =  "qwewrwrr1%e5%85%83%e6%89%8b%e6%9c%ba%e5%85%85%e5%80%bc%e5%8d%a1%e5%b7%b2%e5%85%85%e5%80%bc%e5%88%b0%e8%b4%a6,%e8%af%b7%e6%82%a8%e5%85%b3%e6%b3%a824%e5%b0%8f%e6%97%b6%e5%86%85%e6%89%8b%e6%9c%ba%e8%af%9d%e8%b4%b9%e8%b4%a6%e5%8d%95%e5%8f%98%e5%8c%96%ef%bc%8c%e5%a6%82%e6%9c%89%e9%97%ae%e9%a2%98%e8%af%b7%e8%81%94%e7%b3%bb%e5%9c%a8%e7%ba%bf%e5%ae%a2%e6%9c%8d%e3%80%90jj%e6%af%94%e8%b5%9b%e3%80%91";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        //密码：9787;四小时所有终端可用
        str =  "%c3%dc%c2%eb%a3%ba9787%3b%cb%c4%d0%a1%ca%b1%cb%f9%d3%d0%d6%d5%b6%cb%bf%c9%d3%c3";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        //【j】您正在使用手机验证码登录，验证码是：528430，验证码3分钟内输入有效。如非本人操作，请忽略。
        str =  "%a1%bej%a1%bf%c4%fa%d5%fd%d4%da%ca%b9%d3%c3%ca%d6%bb%fa%d1%e9%d6%a4%c2%eb%b5%c7%c2%bc%a3%ac%d1%e9%d6%a4%c2%eb%ca%c7%a3%ba528430%a3%ac%d1%e9%d6%a4%c2%eb3%b7%d6%d6%d3%c4%da%ca%e4%c8%eb%d3%d0%d0%a7%a1%a3%c8%e7%b7%c7%b1%be%c8%cb%b2%d9%d7%f7%a3%ac%c7%eb%ba%f6%c2%d4%a1%a3";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str =  "%a1%bej%a1%bf%c4%fa%d5%fd%d4%da%ca%b9%d3%c3%ca%d6%bb%fa%d1%e9%d6%a4%c2%eb%b5%c7%c2%bc%a3%ac%d1%e9%d6%a4%c2%eb%ca%c7%a3%ba528430%a3%ac%d1%e9%d6%a4%c2%eb3%b7%d6%d6%d3%c4%da%ca%e4%c8%eb%d3%d0%d0%a7%a1%a3%c8%e7%b7%c7%b1%be%c8%cb%b2%d9%d7%f7%a3%ac%c7%eb%ba%f6%c2%d4%a1%a3";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));
//
        //你好000:sds
        str =  "%e4%bd%a0%e5%a5%bd000%3asds";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));
//
        //你好000:sds
        str =  "%c4%e3%ba%c3000%3asds";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));
//
//
        str =  "%c4%e3%ba%c3000%3asds";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));
//
        str =  "test";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str = "1%E5%85%83%E6%89%8B%E6%9C%BAaadad%E5%80%BC%E5%8D%A1%E5%B7%B2ad%E6%82%A8%E5%85%B3%E6%B3%A8adadadada%E5%8C%96%EF%BC%8C%E5%A6%82%E6%9C%89adada%E9%A2%98adada%E6%9C%8D%E3%80%90jj%E6%AF%94aaa%E3%80%91";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str =  "%c4%e3%ba%c3000%3asds";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str =  "%a1%bej%a1%bf%c4%fa%d5%fd%d4%da%ca%b9%d3%c3%ca%d6%bb%fa%d1%e9%d6%a4%c2%eb%b5%c7%c2%bc%a3%ac%d1%e9%d6%a4%c2%eb%ca%c7%a3%ba528430%a3%ac%d1%e9%d6%a4%c2%eb3%b7%d6%d6%d3%c4%da%ca%e4%c8%eb%d3%d0%d0%a7%a1%a3%c8%e7%b7%c7%b1%be%c8%cb%b2%d9%d7%f7%a3%ac%c7%eb%ba%f6%c2%d4%a1%a3";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "7585";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str = "(1%2f1)%bb%ae%3a%b3%c93%bd%f117472%2c%b3%c92%bd%f182800%2c%b3%c91%bd%f17946%2c%bb%ad1%bd%f121451%2c%b3%e4%3a%bd%f1122942%d7%f2129425";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "%e3%80%90jj%e6%af%94%e8%b5%9b%e3%80%91%e4%ba%b2%e7%88%b1%e7%9a%84%e9%86%89%e7%9c%8b%e9%a3%8e%e6%8b%82%e8%a2%96%c2%b0%ef%bc%8c%e6%82%a8%e7%9a%84%e5%a5%96%e5%93%81%e5%b7%b2%e5%8f%91%e8%b4%a7%ef%bc%8c%e8%af%b7%e6%b3%a8%e6%84%8f%e7%ad%be%e6%94%b6%ef%bc%81%e5%85%b3%e6%b3%a8%e5%be%ae%e4%bf%a1%e6%9c%8d%e5%8a%a1%e5%8f%b7%ef%bc%9ajjfuwuhao%ef%bc%8c%e5%ae%9e%e6%97%b6%e8%b7%9f%e8%b8%aa%e8%ae%a2%e5%8d%95%e7%8a%b6%e6%80%81%ef%bc%81";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str = "bin%2fphp%2ftblistserver%2ftblistserver.php+--tcpaddr%3d0.0.0.0%3a6003+--env%3dprod+--pcfg%3d.%2fconfig%2fprod%2fphp%2f+--l%3d2%a3%ba1%b4%ce%2c%3crpc_admin_reload%3e%7b%22%0a";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));


        str = "%e3%80%90jj%e6%af%94%e8%b5%9b%e3%80%91%e4%ba%b2%e7%88%b1%e7%9a%84%ce%a9%e6%b6%9b%e4%bb%94%ef%bc%8c%e6%82%a8%e7%9a%84%e5%a5%96%e5%93%81%e5%b7%b2%e5%8f%91%e8%b4%a7%ef%bc%8c%e8%af%b7%e6%b3%a8%e6%84%8f%e7%ad%be%e6%94%b6%ef%bc%81%e5%85%b3%e6%b3%a8%e5%be%ae%e4%bf%a1%e6%9c%8d%e5%8a%a1%e5%8f%b7%ef%bc%9ajjfuwuhao%ef%bc%8c%e5%ae%9e%e6%97%b6%e8%b7%9f%e8%b8%aa%e8%ae%a2%e5%8d%95%e7%8a%b6%e6%80%81%ef%bc%81";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));


        str = "(2%2f2)%2c%d7%a2%3a%bd%f1178%d7%f2159%2c%b3%e4%3a%bd%f158536%d7%f258784";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "(1%2f1)%bb%ae%3a%b3%c93%bd%f113870%2c%b3%c92%bd%f13330%2c%b3%c91%bd%f112691%2c%bb%ad1%bd%f110781%2c%b3%e4%3a%bd%f141662%d7%f267427";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "%7b%22msgtype%22%3a%22appcrash%22%2c%22from%22%3a%22nodemgr%22%2c%22appid%22%3a1442%2c%22nodeid%22%3a188%2c%22nodename%22%3a%22sstx155_%e5%ab%ba%a3%bb%a8%ba%a3_00%22%2c%22projid%22%3a2%2c%22projname%22%3a%22t11%22%2c%22appname%22%3a%22gate03%22%2c%22filename%22%3a%22csfs%3agate_server%22%2c%22startupenv%22%3a%22cn0.80_464%22%2c%22workdir%22%3a%22%2fhome%2fubuntu%2fyc%2fserver03%22%2c%22exitcode%22%3a999%7d+";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "%e3%80%90%e5%88%9b%e6%8a%95%e5%9c%88%e3%80%91%e6%b7%a1%e9%a9%ac%e9%94%a1%e7%a5%a5%e5%b3%b0%e6%8a%95%e8%b5%84%c2%b7%e8%91%a3%e4%ba%8b%e7%9a%84%e5%88%98%e5%a4%a9%e7%84%b6%e7%94%b3%e8%af%b7%e6%9f%a5%e7%9c%8b%e6%82%a8%e7%9a%84%e5%95%86%e4%b8%9a%e8%ae%a1%e5%88%92%e4%b9%a6%ef%bc%8c%e6%89%93%e5%bc%80%e5%88%9b%e6%8a%95%e5%9c%88app%e7%ab%8b%e5%8d%b3%e5%a4%84%e7%90%86%e3%80%82";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str = "%e3%80%90%e9%80%94%e6%b8%b8%e6%96%97%e5%9c%b0%e4%b8%bb%e3%80%91%e2%80%8e%e3%82%9b%cb%87%e2%82%af%d9%89%e3%82%9b%ef%bc%8c%e6%82%a8%e6%9c%89%e4%b8%80%e4%b8%aa%e5%a4%a7%e7%a4%bc%e5%8c%85%ef%bc%8c%e6%97%a0%e9%9c%80%e8%b4%ad%e7%89%a9%ef%bc%8c%e5%85%8d%e8%b4%b9%e9%a2%86%e5%8f%96%ef%bc%8c%e6%9c%80%e5%90%8e3%e5%b0%8f%e6%97%b6%ef%bc%81+http%3a%2f%2fsina.lt%2ffm3z+%e9%80%80%e8%ae%a2%e5%9b%9et";
        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str));

        str = "bin%2fphp%2ftblistserver%2ftblistserver.php+--tcpaddr%3d0.0.0.0%3a6003+--env%3dprod+--pcfg%3d.%2fconfig%2fprod%2fphp%2f+--l%3d2%a3%ba4%b4%ce%2c%3calloctable-success%3e%0a";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "%2fbackend%2fcms%2fphp%a3%ba2%b4%ce%2c%3cconsole_monitor%3etes%0a";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "%5b%cd%bc%c6%ac%5d";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

        str = "%2fbackend%2fcms%2fphp%a3%ba3%b4%ce%2c%3cfatalerror%3e%0atype%3a64%0a";
        Assert.assertEquals(false,UrlCharSetUtil.isUTF82(str));

//        str = "%2fbackend%2fcms%2fphp%3f%3f1%3f%3f%3f%3f%3f%3f%3f%3f%3f%2c%3f%bb%c7%3f%3f%3f%3f%3f%3f%3f";
//        Assert.assertEquals(true,UrlCharSetUtil.isUTF82(str)); // 编码有问题不是指定参数单独编码
    }
}
