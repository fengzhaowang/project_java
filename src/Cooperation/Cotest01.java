package Cooperation;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 23 21 : 02
 * @Description: 协作模型：生产者与消费者实现方式一：管程法，借助缓冲区
 * 生产者、消费者、缓冲区、数据
 */
public class Cotest01 {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}
//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //开始生产
        for (int i=0;i<100;i++){
            System.out.println("生产第->"+i+"个馒头");
            container.push(new Steamedbun(i));
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer synContainer) {
        this.container = synContainer;
    }

    @Override
    public void run() {
        //开始消费
        for (int i=0;i<1000;i++){
            System.out.println("消费第->"+(container.pop().id)+"个馒头");
        }
    }
}
//缓冲区
class SynContainer{
    Steamedbun[] buns = new Steamedbun[10];//存储数据的容器
    int count = 0;//计数器
    //存储 生产
    public synchronized void push(Steamedbun bun){
        //何时能生产 容器存在空间时可以生产
        //没有空间  等待生产
        if(count == buns.length){
            try {
                this.wait();//线程阻塞  消费者通知生产解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间  可以生产
        buns[count] = bun;
        count++;
        //存在数据，可以通知消费
        this.notifyAll();
    }
    //获取 消费
    public synchronized Steamedbun pop(){
        //何时消费 容器中是否存在数据
        //没有数据 只有等待
        if(count == 0){
            try {
                this.wait();//线程阻塞  等待生产者通知消费解除阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        Steamedbun bun = buns[count];
        //存在空间，可以唤醒对方生产
        this.notifyAll();
        return bun;
    }
}
//馒头
class Steamedbun{
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}