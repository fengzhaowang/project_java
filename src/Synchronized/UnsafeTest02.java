package Synchronized;

/**
 * 线程不安全
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚礼金");
        Drawing you = new Drawing(account, 80, "可悲的你");
        Drawing wife = new Drawing(account, 90, "happy的她");
        you.start();
        wife.start();
    }
}
//账户
class Account{
    int money;//金额
    String name;//名称
    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{
    Account account;//取钱的账户
    int drawingMoney;//取得钱数
    int packedTotal;//口袋的总数

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);//给thread设置name
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
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