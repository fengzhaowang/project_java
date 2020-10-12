package Server.Web3;

import java.io.IOException;
import java.net.Socket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 13 : 54
 * @Description: 分发器
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
