package cn.diyai.url.encoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by diyai on 2018/5/22.
 */
public class TestHelper {

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

            String logFilePath = "./logs";
            File fileParentDir=new File(logFilePath);//判断log目录是否存在
            if (!fileParentDir.exists()) {
                fileParentDir.mkdir();
            }

            if (fileNameHead==null||fileNameHead.equals("")) {
                logFilePathName=logFilePath+File.separator+year+month+day+".log";//日志文件名
            }else {
                logFilePathName=logFilePath+File.separator+fileNameHead+year+month+day+".log";//日志文件名
            }

            PrintWriter printWriter=new PrintWriter(new FileOutputStream(logFilePathName, true));//紧接文件尾写入日志字符串
            String time="["+year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec+"] ";
            printWriter.println(time+logString);
            printWriter.flush();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

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
}
