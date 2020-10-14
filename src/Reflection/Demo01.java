package Reflection;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 07 : 42
 * @Description: 测试（class,interface,enum,annotation,primitive,type,void）对应的java.lanng.Class对象的获取方式
 */
@SuppressWarnings("all")
public class Demo01 {
    public static void main(String[] args) {
        String path = "Reflection.User";
        try {
            //对象是表示或封装一些数据，一个类被加载后，JVM会创建一个对应类的Class对象，类的整个结构的信息会放到对应的Class对象中
            //这个Class对象就像一面镜子一样，通过这面镜子我们可以看到对应类的全部信息
            Class<?> clazz = Class.forName(path);
            System.out.println(clazz);

            Class<?> clazz2 = Class.forName(path);//一个类只能对应一个Class对象
            System.out.println(clazz2);

            Class strClazz = String.class;//String
            Class strClazz2 = path.getClass();//String
            System.out.println(strClazz);
            System.out.println(strClazz == strClazz2);

            /**
             * 只关注类型，不关注长度
             */
            int[] arr1 = new int[10];
            int[] arr2 = new int[3];
            int[][] arr3 = new int[10][5];
            System.out.println(arr1.getClass().hashCode());
            System.out.println(arr2.getClass().hashCode());
            System.out.println(arr3.getClass().hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
