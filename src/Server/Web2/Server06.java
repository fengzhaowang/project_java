package Server.Web2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 10 20 : 18
 * @Description: 加入了servlet，解耦了云业务代码
 *
 */
public class Server06 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server06 server01 = new Server06();
        server01.start();
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
            Servlet servlet = null;
            if(request.getUrl().equals("login")){
                servlet = new LoginServlet();
            }else if(request.getUrl().equals("register")){
                servlet = new RegisterServlet();
            }else{
                //首页...
                return;
            }
            servlet.service(request,response);
            //状态码
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接出现问题...");
        }
    }
    //停止服务
    public void stop(){

    }
}
