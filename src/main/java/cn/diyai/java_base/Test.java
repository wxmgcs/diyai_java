package cn.diyai.java_base;

public class Test {

    public static int c;


    public static void main(String[] args)
    {
        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2))
            {
                x++;
                ++y;
                k++;
            }
        }
        System.out.println(x + "" +y + "" +k);

        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);

        String s = "null";
        System.out.println("s="+s);

        System. out. println("Value is" + c);

        byte b1=1,b2=2,b3,b6;
        final byte b4=4,b5=6;
        b6=b4+b5;
        b3=(byte)(b1+b2);
        System.out.println(b3+b6);


        Integer i01=59;
        int i02=59;
        Integer i03=Integer.valueOf(59);
        Integer i04=new Integer(59);
        System.out.println(i01==i02);
        System.out.println(i01==i03);
        System.out.println(i03==i04);
        System.out.println(i02==i04);


        System.out.println(Math.round(11.5) );
        System.out.println(Math.round(-11.5) );

        System.out.println(Math.ceil(11.3) ==12);

        System.out.println(Math.ceil(-11.3) == -11);
        System.out.println(Math.ceil(-11.6) == -11);

        System.out.println(Math.floor(11.6) == 11);
        System.out.println(Math.floor(-11.4) == -12);


        new HelloB();

    }

    public final static void test(){

        System. out. println("Value is" + c);
    }

    public final static void test(String test){

        System. out. println("Value is" + c);
    }

}
