package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 08 : 22
 * @Description: 文件类型：接收端
 * Address already in use: Cannot bind 同一个协议下，端口不允许冲突
 * 1、使用 DatagramSocket 指定端口 创建接受端
 * 2、准备容器 封装成DatagramPacket包裹
 * 3、阻塞式接受包裹receiver(DatagramPacket p)
 * 4、分析数据  将自节数组还原为对应的类型
 * byte[] getData()
 * getLength()
 * 5、释放资源
 */
public class UdpFileServer {
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

        byteArrayToFile(datas, "UdpFileServer-phone.jpg");

        //5、释放资源
        server.close();
    }

    public static void byteArrayToFile(byte[] src, String filePath) {
        //创建源
        File file = new File(filePath);
        //选择流
        FileOutputStream fileOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            byteArrayInputStream = new ByteArrayInputStream(src);
            byte[] flush = new byte[1024 * 10];//缓冲容器
            int len = -1;
            //操作（写入）
            while ((len = byteArrayInputStream.read(flush)) != -1) {
                fileOutputStream.write(flush, 0, len);
            }
            //刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
