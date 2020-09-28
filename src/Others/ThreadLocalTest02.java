package Others;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 24 16 : 52
 * @Description: ThreadLocal：每个线程自身的数据，更改不会影响到其他线程
 */
public class ThreadLocalTest02 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(new MyRun()).start();
        }
    }
    public static class MyRun extends Thread{
        @Override
        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() +"得到了-->" + left);
            threadLocal.set(left - 1);
            System.out.println(Thread.currentThread().getName() +"还剩下-->" + threadLocal.get());
        }
    }
}
