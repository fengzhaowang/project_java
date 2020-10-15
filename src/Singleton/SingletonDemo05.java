package Singleton;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 15 : 18
 * @Description: 测试枚举式实现单例模式（没有延时加载）
 * 线程安全，调用效率高，不能延时加载，并且可以天然的防止反射和反序列化漏洞
 */
public enum SingletonDemo05 {
    //这个枚举元素，本身就是单例对象
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperation(){

    }
}
