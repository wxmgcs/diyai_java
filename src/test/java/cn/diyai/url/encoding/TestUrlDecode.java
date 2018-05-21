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

    public static int getCount(String urlencodeUrl){
        int total = 0;
        for(String item:urlencodeUrl.split("%")){
            if(item.length() >= 2){
                char item1 = item.charAt(0);
                char item2 = item.charAt(1);
                if (
                        (('0' <= item1 && '9' >= item1)
                                || ('A' <= item1 && 'F' >= item1)
                                || ('a' <= item1 && 'f' >= item1)
                        ) &&
                                (('0' <= item2 && '9' >= item2)
                                        || ('A' <= item2 && 'F' >= item2)
                                        || ('a' <= item2 && 'f' >= item2)
                                )
                        ){
                    System.out.println(item);
                    total += 1;
                }
            }
        }

        return total;
    }

    public static void main(String[] args) throws  Exception{
        //判断不完全
//        testChiness();

//        getDataSet();

//        verify("亲爱的Ω乱，5000金，仅3天！尽 t.cn/RCHW5rB 百元！退订回T");
//        verify("123亲爱的Ω乱，5000金，仅3天！尽 t.cn/RCHW5rB 百元！退订回T");
//        verify("   亲爱的Ω乱，5000金，仅3天！尽 t.cn/RCHW5rB 百元！退订回T");
//
        //有<符号
        //<u卡贷>根据您的信息，您暂不符合借款条件，故您的借款申请（15000元，12期）审核未通过。如需借款，06月17日后可再次申请【悠融】
        String str = "%3cu%bf%a8%b4%fb%3e%b8%f9%be%dd%c4%fa%b5%c4%d0%c5%cf%a2%a3%ac%c4%fa%d4%dd%b2%bb%b7%fb%ba%cf%bd%e8%bf%ee%cc%f5%bc%fe%a3%ac%b9%ca%c4%fa%b5%c4%bd%e8%bf%ee%c9%ea%c7%eb%a3%a815000%d4%aa%a3%ac12%c6%da%a3%a9%c9%f3%ba%cb%ce%b4%cd%a8%b9%fd%a1%a3%c8%e7%d0%e8%bd%e8%bf%ee%a3%ac06%d4%c217%c8%d5%ba%f3%bf%c9%d4%d9%b4%ce%c9%ea%c7%eb%a1%be%d3%c6%c8%da%a1%bf";
//        str =  "%e4%bd%a0%e5%a5%bd";
        str =  "%e4%bd%a0%e5%a5%bd%c4%e3%ba%c3%a1%be%b3%a9%cc%ec%d3%ce%a1%bf";
//        Assert.assertEquals(false,UrlCharSetUtil.isUTF8(str));




//        System.out.println(URLDecoder.decode("%e4%bd%a0%e5%a5%bd%c4%e3%ba%c3%a1%be%b3%a9%cc%ec%d3%ce%a1%bf","utf-8"));
//
//        System.out.println(URLDecoder.decode("%e4%bd%a0%e5%a5%bd%c4%e3%ba%c3%a1%be%b3%a9%cc%ec%d3%ce%a1%bf","gb2312"));
//        System.out.println(URLDecoder.decode("9368,%e5%85%91%e5%a5%96%e9%aa%8c%e8%af%81%e7%a0%81%e3%80%82%e5%ae%98%e7%bd%91:www.jj.cn%e3%80%90jj%e6%af%94%e8%b5%9b%e3%80%91","utf-8"));
//        System.out.println(isUTF8("9368,%e5%85%91%e5%a5%96%e9%aa%8c%e8%af%81%e7%a0%81%e3%80%82%e5%ae%98%e7%bd%91:www.jj.cn%e3%80%90jj%e6%af%94%e8%b5%9b%e3%80%91"));



//        System.out.println(UrlCharSetUtil.isUTF8(str));
//        System.out.println(URLEncoder.encode(" ", "gbk"));
//        System.out.println(URLEncoder.encode(" ", "gb2312"));
//        System.out.println(URLEncoder.encode(" ", "ISO-8859-1"));

//        System.out.println(URLEncoder.encode("?", "utf-8"));
//        System.out.println(URLEncoder.encode("?", "gb2312"));
//        testDecode();
//        testCreateStr();
//        test_code();
    }

    /*会有问题*/
    public static boolean isUTF8(String url) throws Exception{
        //先用utf-8解码，然后在用utf-8编码，和提交过来编码一样，就是utf-8不一样，就是 gb2312
        return URLEncoder.encode(URLDecoder.decode(url,"utf-8"),"utf-8").equals(url);

    }

    public static void getDataSet() throws  Exception{
        String xpath = "/Users/diyai/workshop/Dump20180521.sql";
//        String xpath = "/Users/diyai/workshop/test_smsinfo.sql";

        FileReader reader = new FileReader(xpath);
        BufferedReader br = new BufferedReader(reader);

        String str = null;
        int totalLines = 0;

        while((str = br.readLine()) != null) {
            totalLines += 1;
            if(str.contains("?")){
                for(String url:str.split("/")){
                    if(url.contains("aspx?")){
                        Map<String, String> mapRequest = URLRequest(url);
                        String msg = mapRequest.get("msg");
                        if(msg == null){
                            continue;
                        }
//                        System.out.println(">> "+msg);
                        write("encoding2",msg);
//                        if(UrlCharSetUtil.isUTF8(msg)){
//                            write("encoding",URLDecoder.decode(msg,"utf-8"));
////                            System.out.println(URLDecoder.decode(msg,"utf-8"));
//                        }else{
//                            write("encoding",URLDecoder.decode(msg,"gb2312"));
////                            System.out.println(URLDecoder.decode(msg,"gb2312"));
//                        }
                        if(isUTF8(msg)){
                            write("encoding2",URLDecoder.decode(msg,"utf-8"));
                        }else{
                            write("encoding2",URLDecoder.decode(msg,"gb2312"));
                        }
                    }
                }
//                break;
            }
        }

        System.out.println(totalLines);
        br.close();
        reader.close();

    }

    /**
     * 解析出url请求的路径，包括页面
     * @param strURL url地址
     * @return url路径
     */
    public static String UrlPage(String strURL)
    {
        String strPage=null;
        String[] arrSplit=null;

        strURL=strURL.trim().toLowerCase();

        arrSplit=strURL.split("[?]");
        if(strURL.length()>0)
        {
            if(arrSplit.length>1)
            {
                if(arrSplit[0]!=null)
                {
                    strPage=arrSplit[0];
                }
            }
        }

        return strPage;
    }
    /**
     * 去掉url中的路径，留下请求参数部分
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String TruncateUrlPage(String strURL)
    {
        String strAllParam=null;
        String[] arrSplit=null;

        strURL=strURL.trim().toLowerCase();

        arrSplit=strURL.split("[?]");
        if(strURL.length()>1)
        {
            if(arrSplit.length>1)
            {
                if(arrSplit[1]!=null)
                {
                    strAllParam=arrSplit[1];
                }
            }
        }

        return strAllParam;
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     * @param URL  url地址
     * @return  url请求参数部分
     */
    public static Map<String, String> URLRequest(String URL)
    {
        Map<String, String> mapRequest = new HashMap<String, String>();

        String[] arrSplit=null;

        String strUrlParam=TruncateUrlPage(URL);
        if(strUrlParam==null)
        {
            return mapRequest;
        }
        //每个键值为一组 www.2cto.com
        arrSplit=strUrlParam.split("[&]");
        for(String strSplit:arrSplit)
        {
            String[] arrSplitEqual=null;
            arrSplitEqual= strSplit.split("[=]");

            //解析出键值
            if(arrSplitEqual.length>1)
            {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

            }
            else
            {
                if(arrSplitEqual[0]!="")
                {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
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
            count = getCount(gb2312str);
            System.out.println("decode(gb2312):"+keyWord+",count(%)="+count);

            String utf8str = URLEncoder.encode(baseStr,"utf-8");
            System.out.println("encode(utf-8):"+utf8str);
//            utf8str = URLEncoder.encode(utf8str,"utf-8");
            keyWord = URLDecoder.decode(utf8str,"utf-8");
            count = getCount(utf8str);
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


    public static String addZero(int i) {
        if (i < 10) {
            String tmpString = "0" + i;
            return tmpString;
        } else {
            return String.valueOf(i);

        }
    }

    public static void write(String fileNameHead,String logString) {

        try {

            String logFilePathName=null;

            Calendar cd = Calendar.getInstance();//日志文件时间

            int year=cd.get(Calendar.YEAR);

            String month=addZero(cd.get(Calendar.MONTH)+1);

            String day=addZero(cd.get(Calendar.DAY_OF_MONTH));

            String hour=addZero(cd.get(Calendar.HOUR_OF_DAY));

            String min=addZero(cd.get(Calendar.MINUTE));

            String sec=addZero(cd.get(Calendar.SECOND));




            File fileParentDir=new File("./log");//判断log目录是否存在

            if (!fileParentDir.exists()) {

                fileParentDir.mkdir();

            }

            if (fileNameHead==null||fileNameHead.equals("")) {
                logFilePathName="./log/"+year+month+day+".log";//日志文件名
            }else {
                logFilePathName="./log/"+fileNameHead+year+month+day+".log";//日志文件名
            }

            PrintWriter printWriter=new PrintWriter(new FileOutputStream(logFilePathName, true));//紧接文件尾写入日志字符串
            String time="["+year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec+"] ";
            printWriter.println(time+logString);
            printWriter.flush();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }

    }
}

//可以查找局部，找到第一个不是%xx的字符，截取这部分作为样本
//
//%C7%D7 %B0%AE %B5%C4 %A6%B8 %C2%D2 %A3%AC 5000 %BD%F0 %A3%AC %BD%F6 3 %CC%EC %A3%A1 %BE%A1 +t.cn %2F RCHW5rB+ %B0%D9 %D4%AA %A3%A1 %CD%CB %B6%A9 %BB%D8 T

//%E4%BA%B2 %E7%88%B1 %E7%9A%84 %CE%A9 %E4%B9%B1 %EF%BC%8C 5000 %E9%87%91 %EF%BC%8C %E4%BB%85 3 %E5%A4%A9 %EF%BC%81 %E5%B0%BD +t.cn %2F RCHW5rB+ %E7%99%BE %E5%85%83 %EF%BC%81 %E9%80%80 %E8%AE%A2 %E5%9B%9E T

//思路按开头为%的每3个字符截取，一直到非%开头为止