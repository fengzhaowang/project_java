package Thread;

/**
 * 创建线程方法二：
 * 1、创建：实现Runnable + 重写run
 * 2、启动：创建实现类对象 + Thread对象 + start
 *
 * 推荐：避免单继承的局限性（继承了一个类就不能继续继承其他的类），有限使用接口
 * 方便共享资源
 */
public class StartRun implements Runnable{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for(int i = 0;i < 20;i++){
            System.out.println("一边听歌！");
        }
    }

    public static void main(String[] args) {
        //创建实现类对象
        StartRun st = new StartRun();
        //创建代理类对象
        Thread runnable = new Thread(st);
        //启动
        runnable.start();

        //如果创建的对象只被调用一次，可以使用下面的匿名书写方式
        //new Thread(new StartRun()).start();

        for(int i = 0;i < 20;i++){
            System.out.println("一边coding！");
        }
    }
}
