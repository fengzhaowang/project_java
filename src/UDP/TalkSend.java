package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 28 10 : 21
 * @Description: 发送端：使用面向对象封装
 */
public class TalkSend implements Runnable{
    private DatagramSocket client;
    private BufferedReader reader;
    private String toURL;
    private int toPort;
    /**
     * port 发送端端口
     * toURL 主机名
     * toPort 端口
     */
    public TalkSend(int port,String toURL,int toPort){
        this.toURL = toURL;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            String data = null;
            try {
                data = reader.readLine();
                byte[] datas = data.getBytes();
                //3、封装成DatagramPacket包裹，需要指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(this.toURL, this.toPort));
                //4、发送包裹send(DatagramPacket p)
                client.send(packet);
                if(data.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //5、释放资源
        client.close();
    }
}
