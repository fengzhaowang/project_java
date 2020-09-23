package Thread;

/**
 * 共享资源，并发（线程安全）
 */
public class Web12306 implements Runnable{
    //票数
    private int ticketNums = 99;
    @Override
    public void run() {
        while (true){
            if(ticketNums < 0){
                break;
            }
            //这里模拟网络延迟，模拟并发状态
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread() 谁运行则代表谁
            System.out.println(Thread.currentThread().getName() + "----->" + ticketNums--);;
        }
    }

    public static void main(String[] args) {
        ///一份资源
        Web12306 web12306 = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web12306,"码畜").start();
        new Thread(web12306,"码农").start();
        new Thread(web12306,"码蟥").start();

    }
}
