package Thread2;

/**
 * join：合并线程，插队线程
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i=0;i<100;i++) {
                System.out.println("lambda...." + i);
            }
        });
        t.start();
        for (int i=0;i<100;i++){
            if(i == 20){
                t.join();//插队  main被阻塞  只能等待lambda执行完成  才能再次继续执行main线程
            }
            System.out.println("main...." + i);
        }
    }
}
