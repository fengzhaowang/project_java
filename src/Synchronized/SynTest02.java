package Synchronized;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 *
 */
public class SynTest02 {
    public static void main(String[] args) {
        //账户
        SafAccount account = new SafAccount(100,"结婚礼金");
        SafeDrawing you = new SafeDrawing(account, 80, "可悲的你");
        SafeDrawing wife = new SafeDrawing(account, 90, "happy的她");
        you.start();
        wife.start();
    }
}
//账户
class SafAccount{
    int money;//金额
    String name;//名称
    public SafAccount(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class SafeDrawing extends Thread{
    SafAccount account;//取钱的账户
    int drawingMoney;//取得钱数
    int packedTotal;//口袋的总数

    public SafeDrawing(SafAccount account, int drawingMoney, String name) {
        super(name);//给thread设置name
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }
    //目标不对，锁定失败，这里不是锁this，应该锁定对象
    //这个地方需要锁的地方首先想到的是run方法中，但测试过后，实际上还是不会保证线程的安全性，还是会产生负数的余额
    public synchronized void test(){
        if (account.money - drawingMoney < 0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packedTotal += drawingMoney;
        System.out.println(this.getName() + "--> 取出金额：" + packedTotal);
        System.out.println(this.getName() + "--> 账户余额：" + account.money);
    }
}