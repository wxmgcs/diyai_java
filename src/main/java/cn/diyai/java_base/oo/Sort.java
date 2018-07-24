package cn.diyai.java_base.oo;


public abstract class Sort {
    public int[] generateArray(int len, int range) {
        if (len < 1) {
            return null;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }

    public void check(){
        int len = 10;
        int range = 10;
        int testTimes = 50000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateArray(len, range);
            exec(arr,arr.length);
            if (!isSorted(arr)) {
                System.out.println("Wrong Case:");
                printArray(arr);
                break;
            }
        }

        int len2 = 13;
        int range2 = 10;
        int testTimes2 = 50000;
        for (int i = 0; i < testTimes2; i++) {
            int[] arr = generateArray(len2, range2);
            exec(arr,arr.length);
            if (!isSorted(arr)) {
                System.out.println("Wrong Case:");
                printArray(arr);
                break;
            }
        }
    }

    private void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private boolean isSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    abstract  int[]  exec(int[] arr,int len);
}
