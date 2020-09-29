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
 * 目标：使用多线实现多个客户可以正常收发多条消息
 * 问题：
 * 1、代码不好维护
 * 2、客户端读写没有分开  必须先写后读
 */
public class ThreadMulitChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Server---------");
        //1、指定端口 使用ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            //2、阻塞式等待连接 accept
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接。。。");
            new Thread(() -> {
                DataInputStream dis = null;
                DataOutputStream dos = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                boolean isRunning = true;
                while (isRunning) {
                    //3、操作 ：输入输出流操作
                    String datas = null;
                    try {
                        datas = dis.readUTF();
                        //4、操作 ： 返回数据
                        dos.writeUTF(datas);
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        isRunning = false;
                    }
                }

                //5、释放资源
                try {
                    if (dos != null) {
                        dos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (dis != null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (client != null) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (server != null) {
                        server.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
