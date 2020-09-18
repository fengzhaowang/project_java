package File;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字符集 ——> 字符
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命生命使命a";

        //编码：字节数组
        byte[] datas = msg.getBytes();

        //解码 String(byte[] bytes, int offset, int length)
        msg = new String(datas,0,datas.length,"UTF-8");
        System.out.println(msg);

        System.out.println("-----------------------");

        //乱码
        //1、字节数不够
        msg = new String(datas,0,datas.length-2,"UTF-8");
        System.out.println(msg);
        //2、字符集不统一
        msg = new String(datas,0,datas.length-2,"GBK");
        System.out.println(msg);
    }
}
