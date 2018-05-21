package cn.diyai.url.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestUrlDecode {


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
        testCreateStr();
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
            keyWord = URLDecoder.decode(gb2312str,"utf-8");
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

    public  static void testCreateStr() throws  Exception{
        String baseStr = "亲爱";
        int count = 0;
        String gb2312str = URLEncoder.encode(baseStr, "GB2312");
        byte[] bytes = gb2312str.getBytes();

        String decodeStr = new String(bytes, 0, bytes.length, "GB2312");
        System.out.println(decodeStr);
    }
}

//可以查找局部，找到第一个不是%xx的字符，截取这部分作为样本
//
//%C7%D7 %B0%AE %B5%C4 %A6%B8 %C2%D2 %A3%AC 5000 %BD%F0 %A3%AC %BD%F6 3 %CC%EC %A3%A1 %BE%A1 +t.cn %2F RCHW5rB+ %B0%D9 %D4%AA %A3%A1 %CD%CB %B6%A9 %BB%D8 T

//%E4%BA%B2 %E7%88%B1 %E7%9A%84 %CE%A9 %E4%B9%B1 %EF%BC%8C 5000 %E9%87%91 %EF%BC%8C %E4%BB%85 3 %E5%A4%A9 %EF%BC%81 %E5%B0%BD +t.cn %2F RCHW5rB+ %E7%99%BE %E5%85%83 %EF%BC%81 %E9%80%80 %E8%AE%A2 %E5%9B%9E T

//思路按开头为%的每3个字符截取，一直到非%开头为止