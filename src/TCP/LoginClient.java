package TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 15 : 10
 * @Description: 模拟登陆（单向）   创建客户器
 * 1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
 * 2、操作 ： 输入输出流操作
 * 3、释放资源
 *  */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Client---------");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String uname = console.readLine();
        System.out.print("请输入密码：");
        String upassword = console.readLine();
        //1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost",8888);
        //2、操作 ： 输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String msg = "hello";
        dos.writeUTF("uname="+uname+"&upassword="+upassword);
        dos.flush();
        //3、释放资源
        dos.close();
        client.close();
    }
}
