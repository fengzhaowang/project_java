package Server.Basic;

import java.lang.reflect.InvocationTargetException;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 20 : 27
 * @Description: 反射：把java类中的各种结构（方法、属性、构造器、类名）映射成一个个的java对象
 * 1、获取Class对象：三种方式：推荐Class.forName("完整路径")
 * 2、可以动态创建对象:：clz.getConstructor().newInstance();
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取Class对象三种方式
        //1、对象.getClass()
        Class clz = new Iphone().getClass();
        //2、类.class()
        clz = Iphone.class;
        //3、Class.forName("包名.类名")
        clz = Class.forName("Server.Basic.Iphone");

        //创建对象
        //jdk9之后不推荐使用
        //Iphone iphone = (Iphone) clz.newInstance();
        //System.out.println(iphone);
        //推荐使用
        Iphone iphone1 = (Iphone) clz.getConstructor().newInstance();
        System.out.println(iphone1);
    }
}
class Iphone{
    public Iphone(){

    }
}
