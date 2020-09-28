package Others;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 25 09 : 49
 * @Description: 可重入锁
 */
public class LockTest01 {
    public void test(){
        //第一次获得锁
        synchronized (this){
            while (true){
                //第二次获得锁
                synchronized (this){
                    System.out.println("ReentrantLock!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        new LockTest01().test();
    }
}
