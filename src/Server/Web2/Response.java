package Server.Web2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 11 10 : 26
 * @Description: todo
 */
public class Response {
    private BufferedWriter writer;
    //正文
    private StringBuilder content;
    //协议头信息（状态行、请求头、回车）
    private StringBuilder headerInfo;
    //正文字节数
    private int len;
    private final String BLANK = " ";
    private final String CRLF = "\r\n";
    private Response() {
        content = new StringBuilder();
        headerInfo = new StringBuilder();
        len = 0;
    }
    public Response(Socket client) {
        this();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headerInfo = null;
        }
    }
    public Response(OutputStream os) {
        this();
        writer = new BufferedWriter(new OutputStreamWriter(os));
    }
    public Response print(String info){
        content.append(info);
        len += info.getBytes().length;
        return this;
    }
    public Response println(String info){
        content.append(info).append(CRLF);
        len += (info+CRLF).getBytes().length;
        return this;
    }
    public void createHeaderInfo(int code){
        //1、响应行：HTTP/1.1 200 OK
        headerInfo.append("HTTP/1.1").append(BLANK);
        headerInfo.append(code).append(BLANK);
        switch (code){
            case 200:
                headerInfo.append("OK").append(CRLF);
                break;
            case 404:
                headerInfo.append("NOT FOUND FILE").append(CRLF);
                break;
            case 505:
                headerInfo.append("SERVER ERROR").append(CRLF);
                break;
            default:
                headerInfo.append("NULL").append(CRLF);
        }
        //2、响应头（最后一行存在空行）：
        headerInfo.append("Date:").append(new Date()).append(CRLF);
        headerInfo.append("Server:shsxt Server/0.0.1;charset=GBK").append(CRLF);
        headerInfo.append("Content-type:text/html").append(CRLF);
        headerInfo.append("Content-length:").append(len).append(CRLF);
        //最后一行存在空行
        headerInfo.append(CRLF);
    }
    //推送响应信息
    public void pushToBrowser(int code) throws IOException {
        if (headerInfo == null) {
            code = 505;
        }
        createHeaderInfo(code);
        writer.append(headerInfo);
        writer.append(content);
        writer.flush();
    }
}
