package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 10 : 21
 * @Description:  接收端：使用面向对象封装
 */
public class TalkReceive implements Runnable{
    private DatagramSocket server;
    private String from;
    public TalkReceive(int port,String from){
        this.from = from;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container, 0, container.length);
            //3、阻塞式接受包裹receiver(DatagramPacket p)
            try {
                server.receive(packet);
                //4、分析数据
                //byte[] getData()
                //getLength()
                byte[] datas = packet.getData();
                String str = new String(datas, 0, packet.getLength());
                System.out.println(this.from+"说："+str);
                if(str.equals("bye")){
                    System.out.println(this.from+"离开了聊天室，输入bye退出聊天");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5、释放资源
        server.close();
    }
}
