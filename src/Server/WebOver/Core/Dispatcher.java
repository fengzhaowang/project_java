package Server.WebOver.Core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 13 : 54
 * @Description: 分发器：加入状态内容处理 404 505 首页
 */
public class Dispatcher implements Runnable{
    private Socket client;
    private Request request;
    private Response response;
    public Dispatcher(Socket client) {
        this.client = client;
        try {
            //获取请求协议
            request = new Request(client);
            //返回响应协议
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }
    @Override
    public void run() {
        try {
            if(request.getUrl() == null || request.getUrl().equals("")){
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("Server/Web4/index.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowser(200);
                is.close();
                return;
            }
            //内容
            Servlet2 servlet = WebApp.getServletFromUrl(request.getUrl());
            if(servlet != null){
                servlet.service(request,response);
                //状态码
                response.pushToBrowser(200);
            }else{
                //错误...
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("Server/Web4/error.html");
                response.print(new String(is.readAllBytes()));
                //状态码
                response.pushToBrowser(404);
                is.close();
            }

        } catch (IOException e) {
            try {
                response.pushToBrowser(500);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        release();
    }
    //释放资源
    private void release(){
        try {
            client.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
