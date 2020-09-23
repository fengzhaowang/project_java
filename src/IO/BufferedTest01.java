package IO;

import java.io.*;

/**
 * 加入字节缓冲流
 * 1、缓冲流提高了性能
 * 2、任何处理流无论怎么嵌套，最底层一定是节点流
 * 3、最后释放只需要释放最外面的处理流，内部会自动释放节点流（如果手动释放，就要从里到外依次释放）
 */
public class BufferedTest01 {
    public static void main(String[] args) {

    }
    //分开写
    public static void copy01() {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        FileInputStream is = null;
        /**
         * 节点流添加缓冲流
         */
        BufferedInputStream buffered = null;
        try {
            is = new FileInputStream(src);
            /**
             * 使用缓冲流
             */
            buffered = new BufferedInputStream(is);
            //3、操作（分段读取）
            /**
             * 此处不需要进行1024*n  因为BufferedInputStream会根据缓冲区的大小来进行独立操作
             */
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
            //4、释放资源（先打开的后关闭）
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(buffered != null){
                    buffered.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //简化写
    public static void copy02() {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        InputStream is = null;
        try {
            /**
             * 直接将BufferedInputStream直接套到需要处理需要提升性能的节点流上
             */
            is = new BufferedInputStream(new FileInputStream(src));
            //3、操作（分段读取）
            /**
             * 此处不需要进行1024*n  因为BufferedInputStream会根据缓冲区的大小来进行独立操作
             */
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
            //4、释放资源（先打开的后关闭）
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
