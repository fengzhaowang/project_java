package Chat;

import java.io.*;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 08 : 30
 * @Description: 在线聊天室：客户端
 * 目标：使用多线程实现多个客户可以正常收发多条消息
 */
public class ThreadMulitClient2 {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Client---------");
        //1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、操作 ： 输入输出流操作
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }
}
