package Chat.Ultimate;

import Chat.Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 10 : 36
 * @Description: 使用多线程封装：发送端
 * 1、发送消息
 * 2、从控制台获取消息
 * 3、释放资源
 * 4、重写run
 */
public class Send implements Runnable{
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private String uname;
    private boolean isRunning = true;

    public Send(Socket client,String uname){
        this.uname = uname;
        this.client = client;
        this.console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
            //发送名称
            send(uname);
        } catch (IOException e) {
            System.out.println("链接创建出错");
            release();
        }
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getStrFromConsole();
            if(!msg.equals("")){
                send(msg);
            }
        }
    }

    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("发送消息出错");
            release();
        }
    }

    /**
     * 从控制台获取数据
     * @return
     */
    private String getStrFromConsole(){
        String msg = "";
        try {
            msg = console.readLine();
        } catch (IOException e) {
            System.out.println("控制台获取数据出错");
            release();
        }
        return msg;
    }

    //释放资源
    private void release(){
        isRunning = false;
        Utils.close(dos,client);
    }
}
