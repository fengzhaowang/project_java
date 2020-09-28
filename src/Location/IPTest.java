package Location;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 25 15 : 07
 * @Description: IP：定位一个节点：计算机、路由、通讯设备等
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        //System.out.println(address.getHostAddress());//本机地址
        //System.out.println(address.getHostName());//计算机名

        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());//本机地址
        System.out.println(address.getHostName());//计算机名
    }

}
