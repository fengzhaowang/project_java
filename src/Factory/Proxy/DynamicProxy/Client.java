package Factory.Proxy.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 20 : 33
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        //代理对象
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Star.class},handler);
        //所有调用的方法都通过StarHandler的invoke方法中
        proxy.sing();
    }
}
