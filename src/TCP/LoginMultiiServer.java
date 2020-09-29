package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 15 : 03
 * @Description: 模拟登陆（双向） 多个客户端请求  创建服务器
 * 1、指定端口  使用ServerSocket 创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作 ： 输入输出流操作
 * 4、释放资源
 */
public class LoginMultiiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---------Server---------");
        //1、指定端口 使用ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        while (isRunning) {
            //2、阻塞式等待连接 accept
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接。。。");
            //3、操作 ：输入输出流操作
            new Thread(new Channel(client)).start();
        }
    }
    //一个Channel就代表一个客户端
    static class Channel implements Runnable {
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;

        public Channel(Socket client) {
            this.client = client;
            try {
                //输入流
                dis = new DataInputStream(client.getInputStream());
                //输出流
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        //接收数据
        private String receive() {
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        //发送数据
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        //释放资源
        private void release() {
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
        }

        @Override
        public void run() {
            String uname = "";
            String upassword = "";
            String[] dataArray = receive().split("&");
            for (String info : dataArray) {
                String[] userInfo = info.split("=");
                if (userInfo[0].equals("uname")) {
                    System.out.println("你的用户名为：" + userInfo[1]);
                    uname = userInfo[1];
                } else if (userInfo[0].equals("upassword")) {
                    System.out.println("你的密码为：" + userInfo[1]);
                    upassword = userInfo[1];
                }
            }
            //返回返回值
            if (uname.equals("1935489961@qq.com") && upassword.equals("fzw5211314wjt")) {
                send("登陆成功！");
            } else {
                send("登陆失败！");
            }
            //释放资源
            release();
        }
    }
}
