package Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 15 : 11
 * @Description: 测试懒汉式单例模式（如何防止反射和反序列化漏洞）
 * 线程安全，调用效率不高，但是，可以延时加载
 */
@SuppressWarnings("all")
public class SingletonDemo06 implements Serializable {
    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
    private static SingletonDemo06 instance;

    //私有化构造器
    private SingletonDemo06(){
        //通过抛异常防止破解单例模式
        if(instance != null){
            throw new RuntimeException();
        }
    }

    //方法同步，调用效率低
    public static synchronized SingletonDemo06 getInstance(){
        if(instance == null){
            instance = new SingletonDemo06();
        }
        return instance;
    }

    //反序列化时，如果定义了readResolve()则直接返回此方法指定的对象，而不需要单独再创建新对象
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }
}
