package Others;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 24 09 : 34
 * @Description: 任务调度Timer和TimerTask
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //执行安排
        timer.schedule(new MyTask(),1000);//一秒后执行
        //timer.schedule(new MyTask(),1000,2000);//一秒后执行，两秒执行一次
    }
}
//任务类
class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("放空大脑休息一会");
    }
}