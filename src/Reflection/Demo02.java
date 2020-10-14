package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 07 : 42
 * @Description: 应用的放射API，获取类的信息（类的名字、属性、方法、构造器等）
 */
@SuppressWarnings("all")
public class Demo02 {
    public static void main(String[] args) {
        String path = "Reflection.User";
        try {
            Class<?> clazz = Class.forName(path);

            //获取类的名字
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName());

            //获取属性
            Field[] fields = clazz.getFields();//只会获得public修饰的属性
            Field[] declaredFields = clazz.getDeclaredFields();//获得所有属性
            Field age = clazz.getDeclaredField("age");
            System.out.println(fields.length);
            System.out.println(declaredFields.length);
            for(Field s:declaredFields){
                System.out.println("属性："+s);
            }
            System.out.println(age);

            //获取方法
            Method[] methods = clazz.getMethods();
            //第一个参数为方法名，第二个参数为传入参数类型，来辨别方法重载问题
            Method methods1 = clazz.getDeclaredMethod("getId",null);
            //如果有参数，则传入对应的参数类型对应的class对象
            Method methods2 = clazz.getDeclaredMethod("setId",int.class);
            for(Method m:methods){
                System.out.println("方法："+m);
            }

            //获取构造器
            Constructor[] constructor = clazz.getDeclaredConstructors();
            Constructor constructor1 = clazz.getConstructor(null);//获取无参构造器
            Constructor constructor2 = clazz.getConstructor(int.class, String.class, int.class);//获得指定传入参数的构造器

            for(Constructor c:constructor){
                System.out.println("构造器："+c);
            }
            System.out.println("构造器："+constructor1);
            System.out.println("构造器："+constructor2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
