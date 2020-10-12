package Server.Web3;

import Server.Web2.Request;
import Server.Web2.Response;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 10 20 : 18
 * @Description: 多线程处理，加入分发器
 *
 */
public class Server08 {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public static void main(String[] args) {
        Server08 server = new Server08();
        server.start();
    }
    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            //多线程
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败...");
        }
    }
    //接受连接处理
    public void receive(){
        while (isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接...");
                new Thread(new Dispatcher(client)).start();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端连接出现问题...");
                stop();
            }
        }
    }
    //停止服务
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
