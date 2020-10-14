package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 10 : 34
 * @Description: 通过跳过安全检查，提高反射效率
 * 三种执行方法的效率差异比较
 */
@SuppressWarnings("all")
public class Demo04 {
    public static void test01(){
        User u = new User();
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 1000000000L;i++){
            u.getUsername();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，执行10亿此，耗时："+(endTime-startTime));
    }
    public static void test02() throws Exception {
        User u = new User();
        Class<? extends User> clazz = u.getClass();
        Method m = clazz.getDeclaredMethod("getUsername", null);
        //m.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 1000000000L;i++){
            m.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射动态方法调用，执行10亿此，耗时："+(endTime-startTime));
    }
    public static void test03() throws Exception {
        User u = new User();
        Class<? extends User> clazz = u.getClass();
        Method m = clazz.getDeclaredMethod("getUsername", null);
        m.setAccessible(true);//不需要执行安全检查
        long startTime = System.currentTimeMillis();
        for(int i = 0;i < 1000000000L;i++){
            m.invoke(u,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法调用，跳过了安全检查，执行10亿此，耗时："+(endTime-startTime));
    }

    public static void main(String[] args) throws Exception{
        test01();
        test02();
        test03();
    }
}
