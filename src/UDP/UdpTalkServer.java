package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 08 : 22
 * @Description: 接收端
 * Address already in use: Cannot bind 同一个协议下，端口不允许冲突
 * 1、使用 DatagramSocket 指定端口 创建接受端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接受包裹receiver(DatagramPacket p)
 * 4、分析数据
 * byte[] getData()
 * getLength()
 * 5、释放资源
 */
public class UdpTalkServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中....");
        //1、使用 DatagramSocket 指定端口 创建接受端
        DatagramSocket server = new DatagramSocket(9999);
        //2、准备容器 封装成DatagramPacket包裹
        while (true) {
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3、阻塞式接受包裹receiver(DatagramPacket p)
            server.receive(packet);
            //4、分析数据
            //byte[] getData()
            //getLength()
            byte[] datas = packet.getData();
            String str = new String(datas, 0, packet.getLength());
            System.out.println(str);
            if(str.equals("bye")){
                break;
            }
        }
        //5、释放资源
        server.close();
    }
}
