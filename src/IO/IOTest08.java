package IO;

import java.io.*;

/**
 * 字节输入流：分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest08 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //3、操作的是字符数组
            //如果使用byte的长度过小，比如小于3，那么中文就会乱码，但是reader不会发生此问题，因为char直接获取的字符
            char[] flush = new char[1024];//缓冲容器
            int len = -1;//接收长度
            while ((len=reader.read(flush)) != -1){
                //字符数组 --> 字符串
                String str = new String(flush,0,len);//len为接收长度
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                //is为null  说明没有使用到is
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
