package Thread2;

/**
 * 线程其他方法
 * isAlive:线程是否还活着
 * Thread.currentThread()：当前线程
 * setName、getName：代理名称
 * 如果想要设置真实角色名称，需要面向对象的思维进行设置
 */
public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        //设置名称：真实角色 + 代理角色
        MyInfo myInfo = new MyInfo("战斗机");
        Thread thread = new Thread(myInfo);
        thread.setName("公鸡");
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isAlive());
    }
}
class MyInfo implements Runnable{
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + name);
    }
}
