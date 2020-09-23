package Synchronized;

/**
 * 线程不安全：票数出现负数，抢的票相同
 */
public class SynBlockTest03 {
    public static void main(String[] args) {
        ///一份资源
        SynWeb12306 web12306 = new SynWeb12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web12306, "码畜").start();
        new Thread(web12306, "码农").start();
        new Thread(web12306, "码蟥").start();
    }
}

class SynWeb12306 implements Runnable {
    //票数
    private int ticketNums = 20;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test4();
        }
    }

    //线程安全：尽可能锁定合理的范围（不是指代码  指的是数据的完整性）
    //double checking
    public void test4() {
        //考虑的是没有票的情况
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        synchronized (this) {
            //考虑的是剩余最后一张票的情况
            if (ticketNums <= 0) {
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

    //同步块
    public void test2() {
        //此处要锁ticketNums和flag，而正好他俩是SynWeb12306对象,子类调用父类只能用this
        synchronized (this) {
            if (ticketNums <= 0) {
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

    //线程不安全，锁不住
    public void test3() {
        synchronized (this) {
            if (ticketNums <= 0) {
                flag = false;
                return;
            }
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

    //线程安全，范围太大，效率低下
    public synchronized void test1() {
        if (ticketNums <= 0) {
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
