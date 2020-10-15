package Singleton;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 15 : 11
 * @Description: 测试懒汉式单例模式
 * 线程安全，调用效率不高，但是，可以延时加载
 */
@SuppressWarnings("all")
public class SingletonDemo02 {
    //类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
    private static SingletonDemo02 instance;

    //私有化构造器
    private SingletonDemo02(){
    }

    //方法同步，调用效率低
    public static synchronized SingletonDemo02 getInstance(){
        if(instance == null){
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
