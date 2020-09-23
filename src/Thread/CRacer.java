package Thread;

import java.util.concurrent.*;

/**
 * 龟兔赛跑模拟多线程
 */
public class CRacer implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        //创建执行服务：
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> racer1 = ser.submit(racer);
        Future<Integer> racer2 = ser.submit(racer);
        //获取结果
        Integer r1 = racer1.get();
        Integer r2 = racer2.get();
        System.out.println(r1 + "==>" + r2);
        //关闭服务
        ser.shutdownNow();
    }

    private static String winner;
    //胜利者

    @Override
    public Integer call() throws Exception{
        for (int steps = 1; steps <= 100; steps++) {
            //模拟兔子休息
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps%10==0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "--->" + steps);
            boolean flag = gameOver(steps);
            if (flag) {
                return steps;
            }
        }
        return null;
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
