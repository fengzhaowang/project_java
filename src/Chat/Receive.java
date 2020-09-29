package Chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 10 : 36
 * @Description: 使用多线程封装：接收端
 * 1、接收消息
 * 2、释放资源
 * 3、重写run
 */
public class Receive implements Runnable{
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning = true;
    public Receive(Socket client){
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("链接创建出错");
            release();
        }
    }
    @Override
    public void run() {
        while (isRunning){
            String msg = receive();
            if(!msg.equals("")){
                System.out.println(msg);
            }
        }
    }

    //接收消息
    private String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("接收消息出错");
            release();
        }
        return msg;
    }

    //释放资源
    private void release(){
        isRunning = false;
        Utils.close(dis,client);
    }
}
