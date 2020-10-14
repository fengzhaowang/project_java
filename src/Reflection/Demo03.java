package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 07 : 42
 * @Description: 通过反射API动态的操作：构造器、方法、属性
 */
@SuppressWarnings("all")
public class Demo03 {
    public static void main(String[] args) {
        String path = "Reflection.User";
        try {
            Class<?> clazz = Class.forName(path);
            //通过反射API调用构造方法，构造对象
            User u = (User)clazz.newInstance();//使用此方法，必须在User对象中添加无参构造，否则传空值报错

            Constructor<User> c = (Constructor<User>)clazz.getDeclaredConstructor(int.class, String.class, int.class);
            User u1 = (User)c.newInstance(1001,"小明",15);
            System.out.println(u1.getId()+"--"+u1.getUsername()+"--"+u1.getAge());

            //通过反射API调用普通方法
            User u2 = (User)clazz.newInstance();
            /**
             * 这两句话相当于u2.setAge();
             */
            Method setAge = clazz.getDeclaredMethod("setAge", int.class);
            setAge.invoke(u2,18);
            System.out.println(u2.getAge());

            //通过反射API操作属性
            /**
             * 此处访问的是对象里面的私有属性private，会有权限问题，如果想要解决，就要加入f.setAccessible(true);
             */
            User u3 = (User)clazz.newInstance();
            Field f = clazz.getDeclaredField("username");
            f.setAccessible(true);//此属性的作用是不需要进行安全检查，可以直接进行访问
            f.set(u3,"小红");//通过反射可以直接写属性
            System.out.println(u3.getUsername());//通过反射可以直接读属性的值
            System.out.println(f.get(u3));



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
