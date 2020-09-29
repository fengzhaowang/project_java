package TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 15 : 03
 * @Description: 模拟登陆（双向）  创建服务器
 * 1、指定端口  使用ServerSocket 创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作 ： 输入输出流操作
 * 4、释放资源
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Server---------");
        //1、指定端口 使用ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接 accept
        //http://localhost:8888/
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接。。。");
        //3、操作：文件拷贝 存储
        BufferedInputStream is = new BufferedInputStream(client.getInputStream());
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("LoginTwoWayServer.jpg"));
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=is.read(flush)) != -1){
            os.write(flush,0,len);
        }
        //4、关闭资源
        os.flush();
        is.close();
        client.close();
        server.close();
    }
}
