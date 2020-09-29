package TCP;

import java.io.*;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 15 : 10
 * @Description: 模拟登陆（双向） 多个客户端请求   创建客户器
 * 1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
 * 2、操作 ： 输入输出流操作
 * 3、释放资源
 */
public class LoginMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Client---------");
        //1、建立连接 ：使用Socket 创建客户端 + 服务器的地址和端口
        Socket client = new Socket("localhost", 8888);
        //2、操作 ： 输入输出流操作  先相应，后请求
        new Send(client).send();
        new Receive(client).receive();
        client.close();
    }

    //发送
    static class Send {
        private Socket client;
        private DataOutputStream dos;
        private BufferedReader console;
        private String msg;

        public Send(Socket client) {
            this.client = client;
            console = new BufferedReader(new InputStreamReader(System.in));
            try {
                dos = new DataOutputStream(client.getOutputStream());
                this.msg = init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String init() {
            try {
                System.out.print("请输入用户名：");
                String uname = console.readLine();
                System.out.print("请输入密码：");
                String upassword = console.readLine();
                return "uname=" + uname + "&upassword=" + upassword;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public void send() {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //接收
    static class Receive {
        private Socket client;
        DataInputStream dis;

        public Receive(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void receive() {
            String result = null;
            try {
                result = dis.readUTF();
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
