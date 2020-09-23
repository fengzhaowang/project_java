package Synchronized;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：线程被覆盖
 */
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());//即使创建了10000个线程，但是添加到数组里面也不会有10000个，因为有些线程被其他线程覆盖掉了
    }
}
