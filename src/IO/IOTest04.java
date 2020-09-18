package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流：分段读取
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest04 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        FileInputStream is = null;
        try {
            is = new FileInputStream(src);
            //3、操作（分段读取）
            //后面的数字代表着每次取得长度，一般以k为单位，为1024*n，如果为其他数字，可能会使下面while多次执行，不能一次性获得文件文本
            //如果byte的长度过小，比如小于3，那么中文就会乱码，但是reader不会发生此问题
            byte[] flush = new byte[1024];//缓冲容器
            int len = -1;//接收长度
            //将内容放入到flush中去，返回得到的长度
            //从read读取后放入缓冲容器，获得长度，并使用string将字节数组转换为字符串
            while ((len=is.read(flush)) != -1){
                System.out.println("read获取的字节长度："+len);
                //字节数组 --> 字符串 （解码）
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
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
