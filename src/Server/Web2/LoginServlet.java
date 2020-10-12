package Server.Web2;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 08 : 42
 * @Description: todo
 */
public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        System.out.println("登录servlet开启。。。");
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("服务器响应成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("欢迎回来："+request.getParameterValue("name"));
        response.print("</body>");
        response.print("</html>");
    }
}
