package TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 15 : 10
 * @Description: 模拟登陆（双向）   创建客户器
 * 1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
 * 2、操作 ： 输入输出流操作
 * 3、释放资源
 *  */
public class FileClient {
    public static void main(String[] args) throws IOException {
        //1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、操作：文件拷贝 拷贝
        BufferedInputStream is = new BufferedInputStream(new FileInputStream("spl.jpg"));
        BufferedOutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=is.read(flush)) != -1){
            os.write(flush,0,len);
        }
        os.flush();
        //3、关闭资源
        os.close();
        is.close();
        client.close();
    }
}
