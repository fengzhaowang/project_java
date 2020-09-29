package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 08 : 30
 * @Description: 在线聊天室：服务端
 * 目标：实现多个客户可以正常收发多条消息
 * 问题：其他客户必须等待之前的客户退出，才能继续排队
 */
public class MulitChat2 {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Server---------");
        //1、指定端口 使用ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            //2、阻塞式等待连接 accept
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接。。。");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            boolean isRunning = true;
            while (isRunning) {
                //3、操作 ：输入输出流操作
                String datas = dis.readUTF();
                //4、操作 ： 返回数据
                dos.writeUTF(datas);
                dos.flush();
            }

            //5、释放资源
            dos.close();
            dis.close();
            client.close();
            server.close();
        }
    }
}
