package cn.diyai.url.encoding;

import java.net.URLDecoder;

/**
 * Created by diyai on 2018/5/21.
 */
public class UrlCharSetUtil {

    /**
     * urlencode使用utf-8编码,每个中文占3个字节
     * 连续找到3个16进制,如果返回的字符串的长度为1,就是utf-8
     * @return
     */
    public static boolean isUTF8(String codingStr) throws  Exception{
        int numChars = codingStr.length();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        char c;
        int encodingCount =  0;
        while (i < numChars) {
            c = codingStr.charAt(i);
            switch (c) {
                case '%':
                        while ( ((i+2) < numChars) &&
                                (c=='%')) {
                            String item = codingStr.substring(i+1,i+3);
//                            System.out.println(item);
                            int v = 0;
                            try{
                                v = Integer.parseInt(item,16);
                            }catch(NumberFormatException e){
                                v = -1;
                            }

                            if( v >= 0){
                                encodingCount += 1;
                                sb.append("%"+item);
                                if(encodingCount >= 3){
                                    i = numChars;
                                    break;
                                }
                            }else{
                                encodingCount = 0;
                                sb = null;
                                sb = new StringBuffer();
                            }
                            i+= 3;
                        }
                default:
                    i++;
                    break;
            }
        }

        String sample =  sb.toString();
        String decodeStr = URLDecoder.decode(sample,"utf-8");
//        System.out.println(decodeStr);
        //使用gb2312解码utf-8会出现乱码
        return decodeStr.length() == 1;
    }
}
