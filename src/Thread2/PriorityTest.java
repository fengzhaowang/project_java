package Thread2;

/**
 * 线程的优先级1-10
 * 1、NORM_PRIORITY 5 默认
 * 2、MIN_PRIORITY 1
 * 3、MAX_PRIORITY  10
 * 所有参数代表的是概率，而不代表绝对的先后顺序
 */
public class PriorityTest {
    public static void main(String[] args) {
        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority,"adidas");
        Thread thread2 = new Thread(myPriority,"NIKE");
        Thread thread3 = new Thread(myPriority,"回力");
        Thread thread4 = new Thread(myPriority,"李宁");
        Thread thread5 = new Thread(myPriority,"双星");
        Thread thread6 = new Thread(myPriority,"puma");

        //设置优先级要在启动之前
        /**
         * 可以使用常亮，也可以使用给定的基准（NORM_PRIORITY，MAX_PRIORITY，MIN_PRIORITY）
         */
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread4.setPriority(Thread.MIN_PRIORITY);
        thread5.setPriority(Thread.MIN_PRIORITY);
        thread6.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}