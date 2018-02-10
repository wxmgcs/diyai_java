package cn.diyai.datastructures.recursion;

/**
 * 递归
 * @author wangxiaomin
 *
 */
public class Recursion {
    Recursion(){
    }

    public int fact(int n){
        if (n== 1){
            return 1;
        }else  if(n==0){
            return 1;
        }else{
            return n * fact(n-1);
        }
    }
}
