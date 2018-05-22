package cn.diyai.url.encoding;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by diyai on 2018/5/21.
 */
public class TestUrlDecode  extends TestCase {


    public static void main(String[] args) throws  Exception{
        String str = null;

//        System.out.println(URLDecoder.decode("%2fbackend%2fcms%2fphp%3f%3f1%3f%3f%3f%3f%3f%3f%3f%3f%3f%2c%3f%bb%c7%3f%3f%3f%3f%3f%3f%3f","gbk"));
//        【jj比赛】亲爱的哟哟，切克闹Ψ，您的奖品已发货，请注意签收！关注微信服务号：jjfuwuhao，实时跟踪订单状态！
        str = "%5b%cd%bc%c6%ac%5d";
//        boolean method1 = UrlCharSetUtil.isUTF8(str);
//        if(method1){
//            System.out.println(URLDecoder.decode(str,"utf-8"));
//        }else{
//            System.out.println(URLDecoder.decode(str,"gb2312"));
//        }

        boolean method2 = UrlCharSetUtil.isUTF82(str);
        if(method2){
            System.out.println(URLDecoder.decode(str,"utf-8"));
        }else{
            System.out.println(URLDecoder.decode(str,"gb2312"));
        }

//        Assert.assertEquals(true,method1);
//        Assert.assertEquals(true,method2);



//        getDataSet();

    }

    public static void getDataSet() throws  Exception{
        String xpath = "/Users/diyai/workshop/sms_logs/Dump20180522.sql";
//        String xpath = "/Users/diyai/workshop/test_smsinfo.sql";

        FileReader reader = new FileReader(xpath);
        BufferedReader br = new BufferedReader(reader);

        String str = null;
        int totalMsg= 0;

        while((str = br.readLine()) != null) {

            if(str.contains("?")){
                for(String url:str.split("/")){
                    if(url.contains("aspx?")){
                        Map<String, String> mapRequest = TestHelper.URLRequest(url);
                        String msg = mapRequest.get("msg");
                        if(msg == null){
                            continue;
                        }
                        totalMsg += 1;
                        boolean v1 = UrlCharSetUtil.isUTF8(msg);
                        boolean v2 = UrlCharSetUtil.isUTF82(msg);
                        if (v1 != v2){
                            System.out.println(">> "+msg);
                            TestHelper.write("encoding",msg);
                            TestHelper.write("encoding",URLDecoder.decode(msg,"utf-8"));
                            TestHelper.write("encoding",URLDecoder.decode(msg,"gb2312"));
                        }
                        //write("encoding",msg);
//                        if(UrlCharSetUtil.isUTF8(msg)){
//                            TestHelper.write("encoding",URLDecoder.decode(msg,"utf-8"));
////                            System.out.println(URLDecoder.decode(msg,"utf-8"));
//                        }else{
//                            TestHelper.write("encoding",URLDecoder.decode(msg,"gb2312"));
////                            System.out.println(URLDecoder.decode(msg,"gb2312"));
//                        }
//                        if(isUTF8(msg)){
//                            write("encoding2",URLDecoder.decode(msg,"utf-8"));
//                        }else{
//                            write("encoding2",URLDecoder.decode(msg,"gb2312"));
//                        }

                        if(totalMsg % 100 == 0){
                            System.out.println(">> "+totalMsg);
                        }


                    }
                }
//                break;
            }
        }

        br.close();
        reader.close();

    }

    public static void verify(String baseStr) throws  Exception{
        String codingStr = URLEncoder.encode(baseStr, "GB2312");
        System.out.println(baseStr+"\t"+codingStr);
        Assert.assertEquals(false,UrlCharSetUtil.isUTF8(codingStr));

        codingStr = URLEncoder.encode(baseStr, "utf-8");
        System.out.println(baseStr+"\t"+codingStr);
        Assert.assertEquals(true,UrlCharSetUtil.isUTF8(codingStr));
    }

    public static void test_code(){
        try {
            // 将application/x-www-from-urlencoded字符串转换成普通字符串

            //gb2312一个中文2个字节，utf-8一个中文3个字节
            String baseStr = "亲爱的Ω乱，5000金，仅3天！尽 t.cn/RCHW5rB 百元！退订回T";
            int count = 0;
            String gb2312str = URLEncoder.encode(baseStr, "GB2312");
            System.out.println("encode(gb2312):"+gb2312str);
//            gb2312str = URLEncoder.encode(gb2312str, "utf-8");
            String keyWord = null;
//            keyWord = URLDecoder.decode(gb2312str,"GB2312");
            keyWord = URLDecoder.decode(gb2312str,"GB2312");
            count = TestHelper.getCount(gb2312str);
            System.out.println("decode(gb2312):"+keyWord+",count(%)="+count);

            String utf8str = URLEncoder.encode(baseStr,"utf-8");
            System.out.println("encode(utf-8):"+utf8str);
//            utf8str = URLEncoder.encode(utf8str,"utf-8");
            keyWord = URLDecoder.decode(utf8str,"utf-8");
            count = TestHelper.getCount(utf8str);
            System.out.println("decode(utf-8):"+keyWord+",count(%)="+count);

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static void isChinese(String strName) {
        char[] ch = strName.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c) == true) {
                System.out.println(isChinese(c));
                return;
            } else {
                System.out.println(isChinese(c));
                return;
            }
        }
    }
    public static void testChiness() throws  Exception{
        Random r = new Random();
//        for(int i=0;i<20;i++)
//            System.out.println(r.nextInt(10)+1);
        isChinese("き");
        isChinese("中国");


        String baseStr = "中国";
        String gb2312str = URLEncoder.encode(baseStr, "gb2312");
        System.out.println("encode(gb2312):"+gb2312str);
        String keyWord = null;
        keyWord = URLDecoder.decode(gb2312str,"gb2312");
        System.out.println(keyWord);
        isChinese(keyWord);

    }

    //区分%E4%B8%AD%E5%9B%BD 是utf-8编码
    //%D6%D0%B9%FA 是gb2312编码 2个字节1个字

    /**
     * URL 编码使用 "%" 其后跟随两位的十六进制数来替换非 ASCII 字符。
     使用 + 来替换空格。
     *
     * @throws Exception
     */

    public static void testDecode() throws  Exception{
        System.out.println(URLDecoder.decode("%E4%B8%AD","gb2312"));
        System.out.println(URLDecoder.decode("%E4%B8%AD","utf-8"));

    }

    public  static void testCreateStr() throws  Exception{
        String baseStr = "中国";
        int count = 0;
        String gb2312str = URLEncoder.encode(baseStr, "GB2312");
        byte[] bytes = gb2312str.getBytes();

        String decodeStr = new String(bytes, 0, bytes.length, "GB2312");
        System.out.println(decodeStr);
    }


    public static void testGB2312()throws  Exception{
//        String baseStr = "浣犲ソ你好【畅天游】";
        String baseStr = "你好:【畅天游】";
        String gb2312str = URLEncoder.encode(baseStr, "gb2312");
        System.out.println("encode(gb2312):"+gb2312str);

        String utf8str = URLEncoder.encode(baseStr, "utf-8");
        System.out.println("encode(utf8str):"+utf8str);

        String gbkstr = URLEncoder.encode(baseStr, "gbk");
        System.out.println("encode(gbkstr):"+gbkstr);

        Assert.assertEquals(true,UrlCharSetUtil.isGB2312(gb2312str));


    }

    public static void testFullDecode() throws  Exception{
        //<u卡贷>根据您的信息，您暂不符合借款条件，故您的借款申请（15000元，12期）审核未通过。如需借款，06月17日后可再次申请【悠融】
        String name = "中";
        String encodeStr1 = URLEncoder.encode(name,"utf-8");
        System.out.println(encodeStr1);

        String encodeStr2 = URLEncoder.encode(name,"gb2312");
        System.out.println(encodeStr2);

        System.out.println(URLDecoder.decode(encodeStr1,"gb2312"));
        System.out.println(URLDecoder.decode(encodeStr1,"utf-8"));

        System.out.println(URLDecoder.decode(encodeStr2,"utf-8"));
        System.out.println(URLDecoder.decode(encodeStr2,"gb2312"));

    }


    /*会有问题*/
    public static boolean isUTF82(String url) throws Exception{
        //先用utf-8解码，然后在用utf-8编码，和提交过来编码一样，就是utf-8不一样，就是 gb2312
        return URLEncoder.encode(URLDecoder.decode(url,"utf-8"),"utf-8").equals(url);

    }

}

//可以查找局部，找到第一个不是%xx的字符，截取这部分作为样本
//
//%C7%D7 %B0%AE %B5%C4 %A6%B8 %C2%D2 %A3%AC 5000 %BD%F0 %A3%AC %BD%F6 3 %CC%EC %A3%A1 %BE%A1 +t.cn %2F RCHW5rB+ %B0%D9 %D4%AA %A3%A1 %CD%CB %B6%A9 %BB%D8 T

//%E4%BA%B2 %E7%88%B1 %E7%9A%84 %CE%A9 %E4%B9%B1 %EF%BC%8C 5000 %E9%87%91 %EF%BC%8C %E4%BB%85 3 %E5%A4%A9 %EF%BC%81 %E5%B0%BD +t.cn %2F RCHW5rB+ %E7%99%BE %E5%85%83 %EF%BC%81 %E9%80%80 %E8%AE%A2 %E5%9B%9E T

//思路按开头为%的每3个字符截取，一直到非%开头为止