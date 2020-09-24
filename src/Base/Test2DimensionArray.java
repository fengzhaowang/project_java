package Base;

public class Test2DimensionArray {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        a[0] = new int[]{10,20,30,40};
        a[1] = new int[]{50,60};
        a[2] = new int[]{70,80,90};
        System.out.println(a[0][2]);

        //静态初始化二维数组
        int[][] b = {
                {10,20,30,40,50},
                {60,70,80},
                {100,200,300}
        };
        System.out.println(b[0][1]);
    }
}
