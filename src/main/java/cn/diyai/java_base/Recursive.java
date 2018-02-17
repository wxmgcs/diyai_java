package cn.diyai.java_base;

/**
 * 递归
 */
public class Recursive {
    public static int f(int x) {
        if (x == 0) {
            return 0;
        } else {
            return 2 * f(x - 1) + x * x;
        }
    }

    /**
     * 阶乘 factorial(5) = 5*4*3*2*1
     * factorial(5) = 5 * factorial(4)
     * factorial(4) = 4 * factorial(3)
     * factorial（3） = 3 * factorial(2)
     * factorial（2） = 2 * factorial(1)
     * factorial（1） = 1
     *
     * @param x
     * @return
     */
    public static int factorial(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }

    }

    public static void printDigit(int n) {
        System.out.print(n);
    }

    /* START: Fig01_04.txt */
    public static void printOut(int n)  /* Print nonnegative n */ {
        if (n >= 10)
            printOut(n / 10);
        printDigit(n % 10);
    }
/* END */

    /* START: Fig02_10.txt*/
    public static long gcd(long m, long n) {
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    /**
     * x的y次方
     * <p>
     * y > 0 每次乘以 x
     * y < 0 除以 x
     *
     * @param x
     * @param y
     * @return
     */
    public static double pow(int x, int y) {
        long result = 1;

        int yABS = Math.abs(y);

        for (int i = 0; i < yABS; i++) {
            result *= x;
        }

        if (y < 0) {
            return 1.0 / result;
        } else {
            return result;
        }
    }

    public static boolean isEven(int n) {

        return n % 2 == 0;
    }

    /* START: Fig02_11.txt*/
    public static long pow2(long x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (isEven(n)) {
            return pow2(x * x, n / 2);
        } else {
            return pow2(x * x, n / 2) * x;
        }
    }


    public static void main(String[] args) {

        System.out.println("f(5) = " + f(5));
        System.out.println("120 = " + factorial(5));

        printOut(1369);
        System.out.println();

        System.out.println("gcd( 45, 35 ) = " + gcd(45, 35));
        System.out.println("gcd( 1989, 1590 ) = " + gcd(1989, 1590));


        System.out.println(" 1 = " + pow(2, 0));
        System.out.println(" 2 = " + pow(2, 1));
        System.out.println(" 8 = " + pow(2, 3));
        System.out.println(" 16 = " + pow(2, 4));
        System.out.println(" 1/2 = " + pow(2, -1));
        System.out.println(" 1/4 = " + pow(2, -2));
        System.out.println(" 1/16 = " + pow(2, -4));

        System.out.println(" compare pow  pow2 = " + pow(2, 21)+" ="+pow2(2,21));


        System.out.println("2^3 = " + pow2(2, 3));
        System.out.println("2^21 = " + pow2(2, 21));
        System.out.println("2^50 = " + pow2(2, 50));


    }
}
