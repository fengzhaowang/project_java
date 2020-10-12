package Server.Web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 10 20 : 18
 * @Description: 封装请求信息中的参数转成map
 *
 */
public class Server05 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server05 server01 = new Server05();
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
            Request02 request = new Request02(client);
            //返回响应协议
            Response response = new Response(client);
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("服务器响应成功");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("我学习了新的东西回来了"+request.getParameterValue("name"));
            response.print("</body>");
            response.print("</html>");
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
