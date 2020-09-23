package Synchronized;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 */
public class SynTest01{
    public static void main(String[] args) {
        ///一份资源
        SafeWeb12306 web12306 = new SafeWeb12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web12306,"码畜").start();
        new Thread(web12306,"码农").start();
        new Thread(web12306,"码蟥").start();
    }
}
class SafeWeb12306 implements Runnable{
    //票数
    private int ticketNums = 20;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }
    public synchronized void test(){
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        //这里模拟网络延迟，模拟并发状态
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread.currentThread() 谁运行则代表谁
        System.out.println(Thread.currentThread().getName() + "----->" + ticketNums--);
    }
}
