package IO;

import java.io.*;

/**
 * 字节数组输入流  ByteArrayInputStream
 *
 * 1、存储在内存中
 * 2、字节数组流不用释放，close为空方法，只是为了统一
 * 3、任何东西都能转成字节数组
 * 4、方便网络进行传输
 *
 * 1、创建源：字节数组，不要太大
 * 2、选择流
 * 3、操作
 * 4、释放资源：可以不用处理
 */
public class IOTest10 {
    public static void main(String[] args) {
        //1、创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        //2、选择流
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(src);
            //3、操作
            byte[] flush = new byte[5];//缓冲容器
            int len = -1;//接收长度
            while ((len=is.read(flush)) != -1){
                //字节数组 --> 字符串 （解码）
                String str = new String(flush,0,len);//len为接收长度
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源（使用ByteArrayInputStream不用设置释放资源，为了统一，也可以保留）
            try {
                //is为null  说明没有使用到is
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
