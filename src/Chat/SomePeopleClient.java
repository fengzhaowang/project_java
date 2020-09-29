package Chat;

import java.io.*;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 08 : 30
 * @Description: 在线聊天室：客户端
 * 目标：加入容器，实现群聊
 */
public class SomePeopleClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Client---------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入姓名：");
        String uname = reader.readLine();
        //1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、操作 ： 输入输出流操作
        new Thread(new Send(client,uname)).start();
        new Thread(new Receive(client)).start();
    }
}
