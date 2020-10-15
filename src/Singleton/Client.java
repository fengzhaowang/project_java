package Singleton;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 15 : 50
 * @Description: todo
 */
@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) {
        //饿汉式
        SingletonDemo01 s1 = SingletonDemo01.getInstance();
        SingletonDemo01 s2 = SingletonDemo01.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        //懒汉式
        System.out.println(SingletonDemo02.getInstance() == SingletonDemo02.getInstance());
        //双层检测锁
        System.out.println(SingletonDemo03.getInstance() == SingletonDemo03.getInstance());
        //静态内部类
        System.out.println(SingletonDemo04.getInstance() == SingletonDemo04.getInstance());
        //枚举
        System.out.println(SingletonDemo05.INSTANCE == SingletonDemo05.INSTANCE);
    }
}
