package Synchronized;

/**
 * 线程不安全：票数出现负数，抢的票相同
 */
public class UnsafeTest01{
    public static void main(String[] args) {
        ///一份资源
        UnSafeWeb12306 web12306 = new UnSafeWeb12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web12306,"码畜").start();
        new Thread(web12306,"码农").start();
        new Thread(web12306,"码蟥").start();
    }
}
class UnSafeWeb12306 implements Runnable{
    //票数
    private int ticketNums = 20;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }
    public void test(){
        if(ticketNums < 0){
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
