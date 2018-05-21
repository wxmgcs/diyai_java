package cn.diyai.url.encoding;

import java.net.URLDecoder;

/**
 * Created by diyai on 2018/5/21.
 */
public class UrlCharSetUtil {

    public static boolean isDebug = true;
    /**
     * urlencode使用utf-8编码,每个中文占3个字节
     * 连续找到3个16进制,如果返回的字符串的长度为1,就是utf-8
     *
     * 支持混编* *
     * @return
     */
    public static boolean isUTF8(String codingStr) throws  Exception{
        int numChars = codingStr.length();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        char c;
        int utf8Count = 0;
        int notUtf8Count = 0;
        int encodingCount =  0;
        while (i < numChars) {
            c = codingStr.charAt(i);
            switch (c) {
                case '%':
                        while ( ((i+2) < numChars) &&
                                (c=='%')) {
                            String item = codingStr.substring(i+1,i+3);

                            if( !isAscii(item)){
                                encodingCount += 1;
                                sb.append("%"+item);
                                if(encodingCount >= 3){
                                    //i = numChars; //退出循环
                                    if(isUTF8(sb)){
                                        utf8Count++;
                                    }else{
                                        notUtf8Count++;
                                    }

                                    sb = null;
                                    sb = new StringBuffer();
                                    encodingCount = 0;
                                }
                            }else{
                                encodingCount = 0;
                                sb = null;
                                sb = new StringBuffer();
                            }
                            i+= 3;
                            if (i < numChars)
                                c = codingStr.charAt(i);
                        }
                default:
                    i++;
                    encodingCount = 0;
                    break;
            }
        }
        System.out.println(utf8Count+":"+notUtf8Count);
        return utf8Count >= notUtf8Count;
    }

    /**
     * 是否是127内的数据
     * @param item
     * @return
     */
    public static boolean isAscii(String item){
        //判断是否是ascii
        int v = 0;
        try{
            v = Integer.parseInt(item,16);
            if(v <= 127){ //0X7F
                return true;
            }
        }catch(NumberFormatException e){
            return true;
        }

        return false;
    }

    public static boolean isUTF8(StringBuffer sb) throws  Exception{

        String sample =  sb.toString();
        String decodeStr = URLDecoder.decode(sample,"utf-8");
//      System.out.println(decodeStr);
        //使用gb2312解码utf-8会出现乱码
        return decodeStr.length() == 1;
    }
}
