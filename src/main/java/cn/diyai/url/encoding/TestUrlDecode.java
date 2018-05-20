package cn.diyai.url.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestUrlDecode {

    public static void main(String[] args) throws  Exception{
        try {
            // 将application/x-www-from-urlencoded字符串转换成普通字符串

            //gb2312一个中文2个字节，utf-8一个中文3个字节
            String baseStr = "亲爱的Ω乱来就乱来，5000金币已到账，仅3天！尽快戳 t.cn/RCHW5rB 百元话费等你拿！退订回T";
            int count = 0;
            String gb2312str = URLEncoder.encode(baseStr, "GB2312");
            String keyWord = URLDecoder.decode(gb2312str,"GB2312");
            count = gb2312str.split("%").length;
            System.out.println("decode(gb2312):"+keyWord+",count(%)="+count);

            String utf8str = URLEncoder.encode(baseStr,"utf-8");
            count = utf8str.split("%").length;
            System.out.println(keyWord+",count(%)="+count);


        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
