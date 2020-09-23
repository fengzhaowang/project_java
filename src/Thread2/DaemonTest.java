package Thread2;

/**
 * 守护线程：是为用户线程服务的，jvm停止不用等待守护线程执行完毕
 * 默认：用户线程，jvm等待用户线程执行完毕才会停止
 *  也适用于implements Runnable
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t = new Thread(god);
        t.setDaemon(true);//将用户线程转换为守护线程，默认所有的线程全部是用户线程，所以守护线程需要使用setDaemon来设置
        t.start();
        new Thread(you).start();
    }
}
class You extends Thread{
    @Override
    public void run() {
        for (int i=1;i<365*100;i++){
            System.out.println("happy life...");
        }
        System.out.println("oooooooo....");
    }
}
class God extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("bless you...");
        }
    }
}