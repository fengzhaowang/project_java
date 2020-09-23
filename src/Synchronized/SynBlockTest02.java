package Synchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全：同步块锁的对象就是要修改的那个对象
 */
public class SynBlockTest02 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                //同步块
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
