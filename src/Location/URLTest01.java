package Location;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 25 15 : 45
 * @Description: URL：统一资源定位器，互联网三大基石之一
 * 1、协议
 * 2、域名、计算机
 * 3、端口：默认80
 * 4、请求自愿
 * http://www.baidu.com:80/index.html?uname=xiaoming&age=18#a
 */
public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=xiaoming&age=18#a");
        //获取四个值
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名 | ip："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("请求资源1："+url.getFile());
        System.out.println("请求资源2："+url.getPath());
        //参数
        System.out.println("参数："+url.getQuery());
        //锚点
        System.out.println("锚点："+url.getRef());
    }
}
