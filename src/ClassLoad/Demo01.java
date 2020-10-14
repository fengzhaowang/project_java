package ClassLoad;

import java.sql.SQLOutput;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 09 : 16
 * @Description: todo
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
        //A a = new A();
        //System.out.println(a.width);

        //被动引用（不会初始化）
        //System.out.println(A.MAX);

        //反射调用
        //Class.forName("ClassLoad.A");

        //被动引用:当访问一个静态域时，只有真正声明这个域的类才会被初始化
        System.out.println(B.width);
    }
}
class A{
    public static int width = 100;
    public static final int MAX = 100;
    static {
        System.out.println("静态初始化A");
        width = 300;
    }
    public A(){
        System.out.println("创建A类的对象");
    }
}

class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}