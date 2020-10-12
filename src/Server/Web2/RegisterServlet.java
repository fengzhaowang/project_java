package Server.Web2;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 08 : 42
 * @Description: todo
 */
public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request,Response response) {
        System.out.println("注册servlet开启。。。");
    }
}
