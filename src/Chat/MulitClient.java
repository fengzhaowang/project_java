package Chat;

import java.io.*;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 08 : 30
 * @Description: 在线聊天室：客户端
 * 目标：实现一个客户可以正常收发消息
 */
public class MulitClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Client---------");
        //1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、操作 ： 输入输出流操作
        /**
         * InputStreamReader：字节流转换为字符流
         * BufferedReader：从字符输入流中读取文本并缓冲字符
         */
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        boolean isRunning = true;
        while (isRunning) {
            String msg = console.readLine();
            dos.writeUTF(msg);
            dos.flush();
            //3、操作 获取返回的数据
            String datas = dis.readUTF();
            if(datas.equals("bye")){
                break;
            }
            System.out.println(datas);
        }
        //4、释放资源
        dis.close();
        dos.close();
        client.close();

    }
}
