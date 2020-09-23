package Thread2;

/**
 * yield礼让线程  暂停线程 直接进入就绪状态 不是进入阻塞状态
 */
public class YieldDemo01 {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--> start");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName() + "--> end");
    }
}