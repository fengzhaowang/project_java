package Thread2;

import javax.swing.plaf.nimbus.State;

public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0;i < 5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("...");
        });

        Thread.State s = t.getState();
        System.out.println(s);//NEW  新生状态

        t.start();
        s = t.getState();
        System.out.println(s);//RUNNABLE  运行状态

        while (true){
            //活动的线程数
            int num = Thread.activeCount();
            System.out.println(num);
            if (num == 2){
                break;
            }
            try {
                Thread.sleep(200);//TIMED_WAITING  等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s = t.getState();//TERMINATED 死亡态
            System.out.println(s);//RUNNABLE  运行状态
        }

    }
}
