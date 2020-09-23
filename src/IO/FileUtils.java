package IO;

import java.io.*;

public class FileUtils {
    public static void main(String[] args) {
        //文件到文件
        try {
            FileInputStream fileInputStream = new FileInputStream("abc.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("copy-abc.txt");
            copy(fileInputStream,fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件到字节数组
        byte[] bytes = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("a.gif");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            copy(fileInputStream,byteArrayOutputStream);
            bytes = byteArrayOutputStream.toByteArray();
            System.out.println(bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字节数组到文件
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            FileOutputStream fileOutputStream = new FileOutputStream("copy-a.gif");
            copy(byteArrayInputStream,fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对接输入输出流
     * @param fileInputStream
     * @param fileOutputStream
     */
    public static void copy(InputStream fileInputStream, OutputStream fileOutputStream) {
        try {
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
            close(fileInputStream,fileOutputStream);
        }
    }

    /**
     * 释放资源
     * @param fileInputStream
     * @param fileOutputStream
     */
    public static void close(InputStream fileInputStream,OutputStream fileOutputStream){
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

    /**
     * 输入流和输出流二者都有一个接口叫Closeable
     * Closeable是可变参数，可变参数的用法是和数组一样的
     * @param ios
     */
    public static void close(Closeable... ios){
        for(Closeable io:ios){
            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
