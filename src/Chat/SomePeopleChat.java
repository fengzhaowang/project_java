package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 08 : 30
 * @Description: 在线聊天室：服务端
 * 目标：加入容器，实现群聊
 */
public class SomePeopleChat {
    /**
     * 在多线程中，如果使用容器，此容器既要改也要遍历（边遍历边用），此时不建议使用ArrayList，可以使用CopyOnWriteArrayList
     */
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException {
        System.out.println("---------Server---------");
        //1、指定端口 使用ServerSocket 创建服务器
        ServerSocket server = new ServerSocket(8888);

        while (true) {
            //2、阻塞式等待连接 accept
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接。。。");
            Channel channel = new Channel(client);
            all.add(channel);//管理所有的成员
            new Thread(channel).start();
        }
    }
    //一个客户端代表一个Channel
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
            } catch (IOException e) {
                System.out.println("链接创建出错");
                release();
            }
        }

        //接收消息
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("接收消息出错");
                release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("发送消息出错");
                release();
            }
        }

        /**
         * 群聊：获取自己的消息，发送给其他人
         * @param msg
         */
        private void sendOthers(String msg){
            for(Channel other:all){
               if(other == this){
                   continue;
               }
               other.send(msg);
            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            Utils.close(dis,dos,client);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if(!msg.equals("")){
                    //send(msg);
                    sendOthers(msg);
                }
            }
        }
    }
}
