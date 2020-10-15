package Singleton;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 14 20 : 34
 * @Description: 测试多线程环境下五种创建单例模式的效率
 */
@SuppressWarnings("all")
public class Client3 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for(int i = 0;i < threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i < 100000;i++){
                        //Object o = SingletonDemo01.getInstance();
                        //Object o2 = SingletonDemo02.getInstance();
                        //Object o3 = SingletonDemo03.getInstance();
                        //Object o4 = SingletonDemo04.getInstance();
                        //Object o5 = SingletonDemo05.INSTANCE;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();//main线程阻塞，直到计数器为0，才会继续往下执行
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }
}