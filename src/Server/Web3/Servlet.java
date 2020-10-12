package Server.Web3;

import Server.WebOver.Core.Servlet2;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 08 : 24
 * @Description: todo
 */
public interface Servlet extends Servlet2 {
    void service(Request request, Response response);
}
