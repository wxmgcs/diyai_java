package cn.diyai.java_base;

import java.util.HashMap;
import java.util.Map;

public class Finder {

    public int findNumSum(String str){
        char s1;

        Map<String,Integer> numMap =new HashMap<String,Integer>();
        String num= "";

        for(int i = 0 ;i < str.length();i++){
            s1 =str.charAt(i);
            if ((s1 > 'A' && s1 < 'Z') || (s1 > 'a' && s1 < 'z')){
                if(!num.equals("")){
                    if(numMap.size() > 0){
                        int oldKey = numMap.get(num);

                        if(oldKey > 0){
                            numMap.put(num+"",oldKey+1);
                        }

                    }else{
                        numMap.put(num+"",1);
                    }
                    num = "";
                }
            }else if(s1 >= '0' && s1 <= '9'){
                num = num+s1;
            }
        }

        for(String key : numMap.keySet()){
            System.out.println(numMap.get(key));

        }



        return 0;
    }

    public static void main(String[] args){
        Finder finder = new Finder();

        System.out.println(finder.findNumSum("9fil3dj11P0jAsf11j"));

    }
}
