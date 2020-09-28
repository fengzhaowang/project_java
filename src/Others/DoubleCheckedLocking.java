package Others;

import java.sql.Time;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 24 16 : 22
 * @Description: DCL单例模式：懒汉式套路上加入并发控制，保证在多线程环境下，对外存一个对象
 * 1、构造器私有化 --> 避免外部new构造器
 * 2、提供私有的静态属性 --> 存储对象的地址
 * 3、提供公共的静态方法 --> 获取属性
 */
public class DoubleCheckedLocking {
    //2、提供私有的静态属性
    //如果没有volatile可能会出现其他线程访问到没有初始化的对象
    private volatile static DoubleCheckedLocking instance;
    //1、构造器私有化
    private DoubleCheckedLocking(){

    }
    //3、提供公共的静态方法
    public static DoubleCheckedLocking getInstance(){
        //再次检测
        if(instance != null){//避免不必要的同步，已经存在对象
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {
            if (instance == null) {
                instance = new DoubleCheckedLocking();
                //1、开辟空间
                //2、初始化对象信息
                //3、返回对象的地址给引用
                //4、可能会发生子类重排，需要加volatile
            }
        }
        return instance;
    }

    //反例 + 网络延迟
    public static DoubleCheckedLocking getInstance2(long time){
            if (instance == null) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new DoubleCheckedLocking();
            }
        return instance;
    }

    public static void main(String[] args) {

//        Thread t = new Thread(()->{
//            System.out.println(DoubleCheckedLocking.getInstance());
//        });
//        t.start();
//        System.out.println(DoubleCheckedLocking.getInstance());

        System.out.println("--------模拟网络延迟进行对比---------");

        //模拟网络延迟
        Thread t2 = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance2(500));
        });
        t2.start();
        System.out.println(DoubleCheckedLocking.getInstance2(1000));
    }

}
