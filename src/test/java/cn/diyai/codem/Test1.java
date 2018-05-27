package cn.diyai.codem;

import cn.diyai.url.encoding.UrlCharSetUtil;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.util.Scanner;

public class Test1 extends TestCase {

//    第一行，两个整数n,m。
//    接下来n行，每行一个正整数ai，以及一个0/1表示是否可以选择特价优惠（1表示可以）。
//    接下来m行，每行两个正整数bi,ci，描述一款满减优惠。
//
//            1 <= n,m <=10
//            1 <= ai <= 100
//            1 <= ci < bi <= 1000

//    一行一个实数，表示至少需要消耗的钱数（保留恰好两位小数）。

//    2 1
//            6 1
//            10 1
//            12 2
//            12.80

//    2 2
//            6 1
//            10 1
//            5 1
//            16 6
//    10.00
    public void test() throws  Exception{
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //单价
        int price = 0;
        //是否是优惠
        int isSpecialOffer;
        //消费总金额
        int bi;
        //优惠
        int ci;

        //总价
        double total = 0;
        //优惠后的总价
        double totalSpecialOffer = 0;
        for(int i = 0; i < n; i++){
            price = sc.nextInt();
            total =  total + price;
            isSpecialOffer = sc.nextInt();
            if(isSpecialOffer == 1){
                totalSpecialOffer =  totalSpecialOffer + price*0.8;
            }else{
                totalSpecialOffer = totalSpecialOffer + price;
            }
        }
        double ans = totalSpecialOffer;
        double tempAns = 0;
        for(int i = 0; i < m; i++){
            bi = sc.nextInt();
            ci = sc.nextInt();
            if(bi>=1 && bi <= 1000 && ci < bi){
                //可满减优惠
                if(bi <= total){
                    tempAns = total - ci;
                    if(tempAns < totalSpecialOffer){
                        ans = tempAns;
                    }
                }
            }
        }
        System.out.println(String.format("%.2f", ans));
    }

}
