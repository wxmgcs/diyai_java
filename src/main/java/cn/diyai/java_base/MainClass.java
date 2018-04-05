package cn.diyai.java_base;

public class MainClass {

    private float f=1.0f;
    int m=12;
    static int n=1;
    public static void main(String args[]){
        MainClass t=new MainClass();
        System.out.println(MainClass.n);

        System.out.println("value="+switchit(4));//3

    }

    /**
     * 没有break,所以会顺序执行,直到结束
     * @param x
     * @return
     */
    public static int switchit(int x) {
        int j=1;
        switch (x) {
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return j+x;
    }

}
