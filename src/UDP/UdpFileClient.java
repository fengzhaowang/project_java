package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 08 : 22
 * @Description: 文件类型：发送端
 *  1、使用 DatagramSocket 指定端口 创建发送端
 *  2、将基本类型 转成字节数组
 *  3、封装成DatagramPacket包裹，需要指定目的地
 *  4、发送包裹send(DatagramPacket p)
 *  5、释放资源
 */
public class UdpFileClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中......");
        //1、使用 DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //2、准备数据，一定要转成字节数组

        byte[] datas = fileToByteArray("phone.jpg");

        //3、封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",9999));
        //4、发送包裹send(DatagramPacket p)
        client.send(packet);
        //5、释放资源
        client.close();
    }

    public static byte[] fileToByteArray(String filePath) {
        //创建源
        File file = new File(filePath);
        //选择流
        FileInputStream fileInputStream = null;//文件流
        ByteArrayOutputStream byteArrayOutputStream = null;//自符数组流
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            //操作
            byte[] flush = new byte[1024 * 10];//缓冲容器
            int len = -1;
            while ((len = fileInputStream.read(flush)) != -1) {
                byteArrayOutputStream.write(flush, 0, len);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //文件流一定要释放，字符数组流不用释放
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
