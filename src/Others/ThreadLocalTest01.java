package Others;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 24 16 : 52
 * @Description: ThreadLocal：每个线程自身的存储本地、局部区域
 * get/set/initialValue
 */
public class ThreadLocalTest01 {
    //private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    //更改初始化值
    /*private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 200;
        }
    };*/
    //jdk8之后又简写为
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 200 );
    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName() +"-->" + threadLocal.get());
        //设置值
        threadLocal.set(300);
        System.out.println(Thread.currentThread().getName() +"-->" + threadLocal.get());

        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }
    public static class MyRun extends Thread{
        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*99));
            System.out.println(Thread.currentThread().getName() +"-->" + threadLocal.get());
        }
    }
}
