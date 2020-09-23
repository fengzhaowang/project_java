package IO;

import java.io.*;

public class IOTest12 {
    public static void main(String[] args) {
        //图片转成字节数组
        byte[] bytes = fileToByteArray("a.gif");
        byteArrayToFile(bytes, "copy_a.gif");

    }

    /**
     * 1、图片读取到字节数组
     * 1）图片到程序 FileInputStream
     * 2）程序到字节数组 ByteArrayOutputStream
     *
     * @param filePath
     * @return
     */
    public static byte[] fileToByteArray(String filePath) {
        //创建源
        File file = new File(filePath);
        //选择流
        FileInputStream fileInputStream = null;//文件流
        ByteArrayOutputStream byteArrayOutputStream = null;//自符数组流
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            //操作
            byte[] flush = new byte[1024 * 10];//缓冲容器
            int len = -1;
            while ((len = fileInputStream.read(flush)) != -1) {
                byteArrayOutputStream.write(flush, 0, len);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //文件流一定要释放，字符数组流不用释放
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 2、字节数组写出到图片
     * 1）字节数组读取到程序  ByteArrayInputStream
     * 2）将程序数据写入到文件  FileOutpuStream
     *
     * @param src
     * @param filePath
     */
    public static void byteArrayToFile(byte[] src, String filePath) {
        //创建源
        File file = new File(filePath);
        //选择流
        FileOutputStream fileOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            byteArrayInputStream = new ByteArrayInputStream(src);
            byte[] flush = new byte[1024 * 10];//缓冲容器
            int len = -1;
            //操作（写入）
            while ((len = byteArrayInputStream.read(flush)) != -1) {
                fileOutputStream.write(flush, 0, len);
            }
            //刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 练习
     *
     * @param filePath
     * @return
     */
    public static byte[] fileToByteArray2(String filePath) {
        //创建源
        File file = new File(filePath);
        //选择流
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            //操作
            byte[] flush = new byte[1024 * 10];//缓冲容器
            int len = -1;
            while ((len = fileInputStream.read(flush)) != -1) {
                byteArrayOutputStream.write(flush, 0, len);
            }
            byteArrayOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 练习
     *
     * @param filePath
     * @return
     */
    public static void byteArrayToFile2(byte[] src, String filePath) {
        //创建源
        File file = new File(filePath);
        //选择流
        FileOutputStream fileOutputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            byteArrayInputStream = new ByteArrayInputStream(src);
            //操作
            byte[] flush = new byte[1024 * 10];
            int len = 1;
            while ((len = byteArrayInputStream.read(flush)) != -1) {
                fileOutputStream.write(flush, 0, len);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
