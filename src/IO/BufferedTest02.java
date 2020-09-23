package IO;

import java.io.*;

/**
 * 加入输入输出字节缓冲流
 * 1、缓冲流提高了性能
 * 2、任何处理流无论怎么嵌套，最底层一定是节点流
 * 3、最后释放只需要释放最外面的处理流，内部会自动释放节点流（如果手动释放，就要从里到外依次释放）
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        copy01("her.JPG","her-noBufferedInputStream.JPG");
        long s2 = System.currentTimeMillis();
        System.out.println("没有加入缓冲流进行copy的使用时间为："+(s2-s1));
        long t1 = System.currentTimeMillis();
        copy02("her.JPG","her-BufferedInputStream.JPG");
        long t2 = System.currentTimeMillis();
        System.out.println("加入缓冲流进行copy的使用时间为："+(t2-t1));
    }

    //加入缓冲流
    public static void copy02(String srcPath, String destPath) {
        //创建源
        File in = new File(srcPath);
        File out = new File(destPath);
        try (InputStream fileInputStream = new BufferedInputStream(new FileInputStream(in));
            OutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(out));){
            //选择流
            /**
             * 直接将BufferedInputStream和BufferedOutputStream直接套到需要处理需要提升性能的输出输入节点流上
             */

            //缓冲容器
            byte[] bytes = new byte[1024];
            //获得字节的长度
            int len = -1;
            //查询数据并写入到新的文件
            while ((len = fileInputStream.read(bytes)) != -1) {
                //将查询到的字节数组写入到文件
                fileOutputStream.write(bytes, 0, len);
            }
            //刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //没有使用缓冲流
    public static void copy01(String srcPath, String destPath) {
        //创建源
        File in = new File(srcPath);
        File out = new File(destPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //选择流
            fileInputStream = new FileInputStream(in);
            fileOutputStream = new FileOutputStream(out);
            //缓冲容器
            byte[] bytes = new byte[1024];
            //获得字节的长度
            int len = -1;
            //查询数据并写入到新的文件
            while ((len = fileInputStream.read(bytes)) != -1) {
                //将查询到的字节数组写入到文件
                fileOutputStream.write(bytes, 0, len);
            }
            //刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源  先打开的后关闭  分别关闭
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
