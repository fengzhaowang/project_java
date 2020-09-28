package UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 08 : 22
 * @Description: 基本类型：接收端
 * Address already in use: Cannot bind 同一个协议下，端口不允许冲突
 * 1、使用 DatagramSocket 指定端口 创建接受端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接受包裹receiver(DatagramPacket p)
 * 4、分析数据  将自节数组还原为对应的类型
 * byte[] getData()
 * getLength()
 * 5、释放资源
 */
public class UdpTypeServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中....");
        //1、使用 DatagramSocket 指定端口 创建接受端
        DatagramSocket server = new DatagramSocket(9999);
        //2、准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3、阻塞式接受包裹receiver(DatagramPacket p)
        server.receive(packet);
        //4、分析数据
        //byte[] getData()
        //getLength()
        byte[] datas = packet.getData();

        //读取
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char chars = dis.readChar();
        System.out.println(msg + "-->" + age + "-->" + flag + "-->" + chars);

        //5、释放资源
        server.close();
    }
}
