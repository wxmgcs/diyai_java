package cn.diyai.java_base;

import java.util.Arrays;

public class ArrayDemo {

    public void arrayCopyOfDemo(){
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd' };

        char[] copyTo = Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo));
        System.out.println(Math.min(copyFrom.length-2,9));
    }


    public void arrayCopyDemo(){
        char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
    }

    public void multiDimArrayDemo(){
        String[][] names = { { "Mr. ", "Mrs. ", "Ms. " }, { "Smith", "Jones" } };
        // Mr. Smith
        System.out.println(names[0][0] + names[1][0]);
        // Ms. Jones
        System.out.println(names[0][2] + names[1][1]);
    }

    public void arrayDemo(){
        int[] anArray = new int[10];

        anArray[0] = 100;
        anArray[1] = 200;
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        for(int i = 0 ; i < 10 ;i++){
            System.out.println("Element at index "+i+": " + anArray[i]);
        }
    }

    public static void main(String[] args){
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.arrayCopyDemo();
        arrayDemo.arrayCopyOfDemo();
        arrayDemo.multiDimArrayDemo();
        arrayDemo.arrayDemo();




    }
}
