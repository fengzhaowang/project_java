package Thread;

/**
 * 创建线程方法一：
 * 1、创建：继承Thread + 重写run
 * 2、启动：创建子类对象 + start
 */
public class StartThread extends Thread{
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
        //创建线程子类对象
        StartThread st = new StartThread();
        //启动新线程，交给CPU进行调用（不会等待进行完毕，直接往下运行）
        st.start();//不能保证立即运行，由cpu调用
        //st.run();//普通方法调用，一条线调用上面的run方法，调用完往下运行，没有涉及多线程
        for(int i = 0;i < 20;i++){
            System.out.println("一边coding！");
        }
    }
}
