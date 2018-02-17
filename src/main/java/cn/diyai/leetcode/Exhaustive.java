package cn.diyai.leetcode;

/**
 * Given n points on a 2D plane,
 * find the maximum number of points that lie on the same straight line.
 */
public class Exhaustive {

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    /**
     * 两点就可以形成一条直线
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        int max = 0;
        int currentMax = 1;
        Point outPoint = null;
        Point inPoint = null;
        double outSlope = 0f;
        double  intSlope = 0f;

       // boolean isZeroPoint = false;
        if (points.length <= 2){
            return points.length;
        }

        for(int outI  = 0; outI < points.length;outI++){
            outPoint = points[outI];
//
//            if(outPoint.y == 0  && outPoint.x == 0 && points.length > 1){
//
//            }

            //一样的斜率
            if (outPoint.x == 0){
                outSlope = 0;
            }else{
                //斜率
                outSlope = outPoint.y*1.0/outPoint.x;
            }

            for(int inI  = 0; inI < points.length;inI++){
                if (inI == outI) continue;
                inPoint = points[inI];

                if (inPoint.x == outPoint.x){
                    if(Math.abs(inPoint.y) == Math.abs(outPoint.y)){
                        currentMax += 1;
                        continue;
                    }
                }

                if (inPoint.y == outPoint.y){
                    if(Math.abs(inPoint.x) == Math.abs(outPoint.x)){
                        currentMax += 1;
                        continue;
                    }
                }

                if (inPoint.x == 0){
                    intSlope = 0;
                }else{
                    //斜率
                    intSlope = inPoint.y*1.0/inPoint.x;
                }

                if (intSlope == outSlope){
                    currentMax += 1;

                }
            }

            if(currentMax > max){
                max =  currentMax;
            }

            currentMax = 0;
        }

        return max;
    }

    public int maxPoints2(Point[] points) {
        //关键在于判断三点共线，两平行直线有且只有一个交点，所以有一个中间点，这个中间点与另外两个端点的连线的斜率相等
        //由比率的性质
        int ABx;
        int ABy;
        int BCx;
        int BCy;

        if(points.length<=2) return points.length;
        int max=2;//用来记录最大个数

        for(int i=0;i<points.length;i++){
            int num=0;
            int temp=1;

            for(int j=i+1;j<points.length;j++){
                ABx=points[i].x-points[j].x;
                ABy=points[i].y-points[j].y;
                if(ABx==0 && ABy==0)//表示出现重复点
                {
                    num++;
                }else{
                    temp++;
                    for(int k=j+1;k<points.length;k++){
                        BCx=points[j].x-points[k].x;
                        BCy=points[j].y-points[k].y;
                        if(ABx*BCy==BCx*ABy){//表示两个斜率相等，转化为乘积的形式可以避免分母为0的情况
                            temp++;
                        }
                    }
                }
                if(max<(num+temp)){
                    max=num+temp;
                }
                temp=1;
            }

        }
        return max;
    }


    public static void main(String[] args) {
        Exhaustive exhaustive = new Exhaustive();

        Point[] points = null;
        points = new Point[]{
                new Point(1,2),
                new Point(2,3),
                new Point(3,4),
                new Point(2,4),
                new Point(4,5)};
        System.out.println(String.format("maxPoints %s %s = 2", "在一条线上的点的个数", exhaustive.maxPoints(points)));
        System.out.println(String.format("maxPoints2 %s %s = 2", "在一条线上的点的个数", exhaustive.maxPoints2(points)));
        System.out.println();

        points = new Point[]{};
        System.out.println(String.format("maxPoints %s %s = 0", "在一条线上的点的个数", exhaustive.maxPoints(points)));
        System.out.println(String.format("maxPoints2 %s %s = 0", "在一条线上的点的个数", exhaustive.maxPoints2(points)));
        System.out.println();

        points = new Point[]{
                new Point(0,0),
                new Point(0,0),
        };
        System.out.println(String.format("maxPoints %s %s = 2", "在一条线上的点的个数", exhaustive.maxPoints(points)));
        System.out.println(String.format("maxPoints2 %s %s = 2", "在一条线上的点的个数", exhaustive.maxPoints2(points)));
        System.out.println();

        points = new Point[]{
                new Point(0,0),
                new Point(1,1),
                new Point(1,-1),
        };
        System.out.println(String.format("maxPoints %s %s = 2", "在一条线上的点的个数", exhaustive.maxPoints(points)));
        System.out.println(String.format("maxPoints2 %s %s = 2", "在一条线上的点的个数", exhaustive.maxPoints2(points)));
        System.out.println();

        points = new Point[]{
                new Point(0,0),
        };
        System.out.println(String.format("maxPoints %s %s = 1", "在一条线上的点的个数", exhaustive.maxPoints(points)));
        System.out.println(String.format("maxPoints2 %s %s = 1", "在一条线上的点的个数", exhaustive.maxPoints2(points)));
        System.out.println();


    }


}
