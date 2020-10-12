package Server.Web3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 10 20 : 18
 * @Description: 整合配置文件
 *
 */
public class Server07 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server07 server = new Server07();
        server.start();
    }
    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败...");
        }
    }
    //接受连接处理
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接...");
            //获取请求协议
            Request request = new Request(client);
            //返回响应协议
            Response response = new Response(client);

            //内容
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());

            if(servlet != null){
                servlet.service(request,response);
                //状态码
                response.pushToBrowser(200);
            }else{
                //错误...
                //状态码
                response.pushToBrowser(404);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接出现问题...");
        }
    }
    //停止服务
    public void stop(){

    }
}
