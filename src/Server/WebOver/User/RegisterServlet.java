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
public class RegisterServlet implements Servlet2 {
    @Override
    public void service(Request request, Response response) {
        System.out.println("------------------------");
        //关注业务逻辑
        String uname = request.getParameterValue("uname");
        String[] favs = request.getParameterValues("fav");
        response.print("<html>");
        response.print("<head>");
        response.print("<meta charset='UTF-8'>");
        response.print("<meta name='viewport' content='width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0'>");
        response.print("<meta http-equiv='X-UA-Compatible' content='ie=edge'>");
        response.print("<title>");
        response.print("注册成功");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.println("你注册的信息为："+uname);
        response.println("你喜欢的语言为：");
        for (String v:favs){
            if(v.equals("0")){
                response.print("java");
            }else if(v.equals("1")){
                response.print("c/c++");
            }else if(v.equals("2")){
                response.print("html+css+javascript");
            }
        }
        response.print("</body>");
        response.print("</html>");
    }
}
