package Chat.Ultimate;

import Chat.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 08 : 30
 * @Description: 在线聊天室终极版本：服务端
 * 目标：加入私聊
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
        private String uname;
        private boolean isRunning;
        public Channel(Socket client){
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                isRunning = true;
                //获取名称
                this.uname = receive();
                //欢迎你的到来
                this.send("欢迎你的到来");
                sendOthers(this.uname+"加入聊天室",true);
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
         * 私聊：约定数据格式：@xxx:msg
         * @param msg
         */
        private void sendOthers(String msg,boolean isSys){
            boolean isPrivate = msg.startsWith("@");
            if(isPrivate){//私聊
                int idx = 0;
                if(msg.contains(":")){
                    idx = msg.indexOf(":");
                }else if(msg.contains("：")){
                    idx = msg.indexOf("：");
                }else{
                    System.out.println("私聊错误");
                }
                //获取目标和数据
                String targetName = msg.substring(1,idx);
                msg = msg.substring(idx+1);
                for (Channel other : all) {
                   if(other.uname.equals(targetName)){//目标
                       other.send(this.uname + "悄悄的对您说" + msg);
                   }else{
                       System.out.println("私聊错误");
                   }
                }
            }else {
                for (Channel other : all) {
                    if (other == this) {
                        continue;
                    }
                    if (!isSys) {
                        other.send(this.uname + "对所有人说" + msg);//群聊消息
                    } else {
                        other.send(msg);//系统消息
                    }
                }
            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            Utils.close(dis,dos,client);
            all.remove(this);
            sendOthers(this.uname+"离开了群聊...",true);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if(!msg.equals("")){
                    //send(msg);
                    sendOthers(msg,false);
                }
            }
        }
    }
}
