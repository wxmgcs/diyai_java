package cn.diyai.java_base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读缓存流
 */
public class BufferedReaderDemo {

    public int divid() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int x;
        String oneLine;
        System.out.println("Enter an integer: ");

        try {
            oneLine = in.readLine();
            x = Integer.parseInt(oneLine);
            return (x / 2);
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }


    /**
     * @param fileName
     */
    public static void listFile(String fileName) {
        FileReader theFile;
        BufferedReader fileIn = null;
        String oneLine;

        System.out.println("FILE: " + fileName);
        try {
            theFile = new FileReader(fileName);
            fileIn = new BufferedReader(theFile);
            while ((oneLine = fileIn.readLine()) != null){
                System.out.println(oneLine);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            if (fileIn != null)
              fileIn.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedReaderDemo bufferedReaderDemo = new BufferedReaderDemo();
        System.out.println("读缓存流实现除2:" + bufferedReaderDemo.divid());

        if (args.length == 0) {
            System.out.println("No files specified");
            for (int i = 0; i < args.length; i++)
                listFile(args[i]);
        }
    }

}
