package Server.WebOver.User;

import Server.WebOver.Core.Request;
import Server.WebOver.Core.Response;
import Server.WebOver.Core.Servlet2;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 08 : 42
 * @Description: todo
 */
public class LoginServlet implements Servlet2 {
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<meta charset='UTF-8'>");
        response.print("<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>");
        response.print("<meta http-equiv='X-UA-Compatible' content='ie=edge'>");
        response.print("<title>");
        response.print("服务器响应成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("欢迎回来："+request.getParameterValue("uname"));
        response.print("</body>");
        response.print("</html>");
    }
}
