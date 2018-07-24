package cn.diyai.java_base.oo;

public class Client {

    public static void main(String[] args) {
        Sort sort = new InsertionSort();
        for(int i: sort.exec(new int[]{1,3,2},3)){
            System.out.println(i);
        }

    }
}
