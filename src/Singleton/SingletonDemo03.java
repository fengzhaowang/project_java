package Singleton;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 15 : 45
 * @Description: 双重检测锁实现
 * 由于JVM底层内部模型原因，偶尔会出问题，不建议使用
 */
public class SingletonDemo03 {
    private static SingletonDemo03 instance = null;
    public static SingletonDemo03 getInstance(){
        if(instance == null){
            SingletonDemo03 sc;
            synchronized (SingletonDemo03.class){
                sc = instance;
                if(sc == null){
                    synchronized (SingletonDemo03.class){
                        if(sc == null){
                            sc = new SingletonDemo03();
                        }
                    }
                    instance = sc;
                }
            }
        }
        return instance;
    }

    public SingletonDemo03() {
    }
}
