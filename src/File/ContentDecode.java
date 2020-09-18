package File;

import java.io.UnsupportedEncodingException;

/**
 * 编码：字符 ——> 字符集
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命生命使命a";

        //编码：字节数组
        byte[] datas = msg.getBytes();
        System.out.println(datas.length);

        //其他编码格式
        datas = msg.getBytes("UTF-16LE");
        System.out.println(datas.length);

        datas = msg.getBytes("GBK");
        System.out.println(datas.length);
    }
}
