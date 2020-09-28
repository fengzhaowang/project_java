package UDP;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 10 : 42
 * @Description: todo
 */
public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkSend(9998,"localhost",6665)).start();//发送端

        new Thread(new TalkReceive(6666,"老师")).start();//接收端
    }
}
