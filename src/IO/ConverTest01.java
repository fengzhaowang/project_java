package IO;

import java.io.*;

/**
 * 转换流InputStreamReader  OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本）
 * 2、指定字符集
 */
public class ConverTest01 {
    public static void main(String[] args) throws IOException {
        //此处传过来的都是字符串，所以字符串的地方最好加上BufferedReader和BufferedWriter承载缓冲
        //System.in和System.ou都是字节输出流，通过InputStreamReader和OutputStreamWriter转换为字符流，再通过字符流处理（BufferedReader和BufferedWriter）
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
            String msg = "";
            while (!msg.equals("exit")){
                msg = reader.readLine();
                writer.write(msg);
                writer.flush();
            }
        }catch (IOException e){
            System.out.println("程序报错"+e);
        }
    }
}
