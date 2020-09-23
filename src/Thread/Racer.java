package Thread;

/**
 * 龟兔赛跑模拟多线程
 */
public class Racer implements Runnable {
    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "兔子").start();
        new Thread(racer, "乌龟").start();
    }

    private static String winner;
    //胜利者

    @Override
    public void run() {
        for (int steps = 1; steps <= 100; steps++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && steps%10==0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + steps);
            boolean flag = gameOver(steps);
            if (flag) {
                break;
            }
        }
    }

    public boolean gameOver(int steps) {
        if (winner != null) {//存在胜利者
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner ==>" + winner);
            }
        }
        return false;
    }
}
