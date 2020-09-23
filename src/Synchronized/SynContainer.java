package Synchronized;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全：操作并发容器
 * list有对应的并发容器，不用自己锁定，内部已经实现了锁，也就是CopyOnWriteArrayList
 */
public class SynContainer {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
