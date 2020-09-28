package Others;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 25 09 : 49
 * @Description: 可重入锁：锁可以延续使用 + 计数器
 */
public class LockTest03 {
    UnLock lock = new UnLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("第一次锁："+lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println("第一次解锁："+lock.getHoldCount());
    }
    //不可重入
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println("第二次锁："+lock.getHoldCount());
        //........
        lock.unlock();
        System.out.println("第二次解锁："+lock.getHoldCount());
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.a();
        System.out.println("main方法锁："+test.lock.getHoldCount());
    }
}

//可重入锁
class UnLock{
    //是否占用
    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int holdCount = 0;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked && lockedBy != t){
            wait();
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }
    //释放锁
    public synchronized void unlock(){
        if(lockedBy == Thread.currentThread()){
            holdCount--;
            if(holdCount == 0){
                isLocked = false;
                notifyAll();
                lockedBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}
