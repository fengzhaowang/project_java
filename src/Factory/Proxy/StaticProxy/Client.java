package Factory.Proxy.StaticProxy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 20 : 19
 * @Description: 代理模式-静态代理
 */
@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) {
        RealStar realStar = new RealStar();//真正的歌手
        ProxyStar proxyStar = new ProxyStar(realStar);//代理人

        proxyStar.bookTicket();
        proxyStar.collectMoney();
        proxyStar.confer();
        proxyStar.sing();//代理人不会唱歌，但是可以代理找真正的歌手
        proxyStar.singContract();
    }
}
