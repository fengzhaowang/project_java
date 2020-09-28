package UDP;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 10 : 42
 * @Description: todo
 */
public class TalkTeacher {
    public static void main(String[] args) {
        new Thread(new TalkReceive(6665,"学生")).start();//接收端

        new Thread(new TalkSend(9999,"localhost",6666)).start();//发送端
    }
}
