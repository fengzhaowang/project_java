package Synchronized;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1、同步方法
 * 2、同步块
 */
public class SynBlockTest01 {
    public static void main(String[] args) {
        //账户
        SafAccounts account = new SafAccounts(100, "结婚礼金");
        SafeDrawings you = new SafeDrawings(account, 80, "可悲的你");
        SafeDrawings wife = new SafeDrawings(account, 90, "happy的她");
        you.start();
        wife.start();
    }
}

//账户
class SafAccounts {
    int money;//金额
    String name;//名称

    public SafAccounts(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟取款，线程安全
class SafeDrawings extends Thread {
    SafAccounts account;//取钱的账户
    int drawingMoney;//取得钱数
    int packedTotal;//口袋的总数

    public SafeDrawings(SafAccounts account, int drawingMoney, String name) {
        super(name);//给thread设置name
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    //目标锁定SafAccounts
    public void test() {
        //提高性能
        if(account.money <= 0){
            return;
        }
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
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
}