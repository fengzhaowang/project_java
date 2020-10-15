package Singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 15 : 50
 * @Description: 测试反射和反序列化破解单例模式
 */
@SuppressWarnings("all")
public class Client2{
    public static void main(String[] args) throws Exception{
        //饿汉式
        SingletonDemo06 s1 = SingletonDemo06.getInstance();
        SingletonDemo06 s2 = SingletonDemo06.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        /**
         * 破解单例模式：
         * 解决办法：在对应的模式的构造器中添加抛异常机制
         * 通过抛异常防止破解单例模式
         * if(instance != null){
         *    throw new RuntimeException();
         * }
         */
        //通过反射的方式直接调用私有构造器
        /*Class<SingletonDemo06> clazz = (Class<SingletonDemo06>)Class.forName("Singleton.SingletonDemo06");
        Constructor<SingletonDemo06> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        SingletonDemo06 c3 = c.newInstance();
        SingletonDemo06 c4 = c.newInstance();
        System.out.println(c3);
        System.out.println(c4);*/

        /**
         * 破解单例模式：
         * 反序列化时，如果定义了readResolve()则直接返回此方法指定的对象，而不需要单独再创建新对象
         * private Object readResolve() throws ObjectStreamException{
         *    return instance;
         * }
         */
        //通过反序列化构造多个对象
        FileOutputStream fos = new FileOutputStream("D:/a.txt");
        ObjectOutputStream obj = new ObjectOutputStream(fos);
        obj.writeObject(s1);
        obj.close();
        fos.close();

        ObjectInputStream ins = new ObjectInputStream(new FileInputStream("D:/a.txt"));
        SingletonDemo06 s6 = (SingletonDemo06)ins.readObject();
        System.out.println(s6);

    }
}
