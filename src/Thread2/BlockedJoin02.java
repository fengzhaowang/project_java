package Thread2;

import TreeMap.TreeMap;

/**
 * join：合并线程，插队线程
 */
public class BlockedJoin02 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Father()).start();
    }
}
class Father extends Thread{
    @Override
    public void run() {
        System.out.println("想抽烟，发现没了");
        System.out.println("让儿子去买中华");
        Thread thread = new Thread(new Son());
        thread.start();
        try {
            thread.join();//father被阻塞，转成
            System.out.println("老爸接过烟，把零钱给了儿子");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("孩子走丢了，老爸找孩子去了");
        }
    }
}
class Son extends Thread{
    @Override
    public void run() {
        System.out.println("接过老爸的钱出去了");
        System.out.println("路过有个游戏厅，玩了10秒");
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+"秒过去了。。。。");
        }
        System.out.println("赶紧去买烟。。。");
        System.out.println("手拿一包中华回家了");
    }
}
