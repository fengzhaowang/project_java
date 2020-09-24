package Cooperation;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 24 09 : 02
 * @Description: 协作模型：生产者消费者实现方式二：信号灯法
 * 借助标志位
 */
public class Cotest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}
//生产者  演员
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            tv.play("第"+(i+1)+"场戏");
        }
    }
}
//消费者  观众
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            this.tv.watch();
        }
    }
}
//同一个资源  电视
class Tv{
    String voice;
    //信号灯
    //T 演员表演 观众等待
    //F 演员等待 观众观看
    boolean flag = true;

    //演员表演
    public synchronized void play(String voice){
        //什么时候等待 信号灯为T时表演  信号灯为F时等待
        //等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //表演
        System.out.println("表演了"+voice);
        this.voice = voice;
        //表演完开始让观众观看
        this.notifyAll();
        //切换标志（红绿灯）
        this.flag = !this.flag;
    }
    //观众观看
    public synchronized void watch(){
        //什么时候观看 信号灯为F时观看 信号灯为T时等待
        //等待
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //观看
        System.out.println("看到了"+voice);
        //观看完让演员开始表演
        this.notifyAll();
        //切换标志（红绿灯）
        this.flag = !this.flag;
    }
}
