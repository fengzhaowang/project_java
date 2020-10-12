package Server.Web3;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 11 : 21
 * @Description: todo
 */
public class OtherServlet implements Servlet {

    @Override
    public void service(Request request, Response response) {
        System.out.println("其他页面.......");
    }

    @Override
    public void service(Server.WebOver.Core.Request request, Server.WebOver.Core.Response response) {

    }
}
