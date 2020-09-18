package IO;

import java.io.*;

/**
 * 文件的拷贝
 */
public class IOTest07 {
    public static void main(String[] args) {
        copy("a.gif","b.gif");
    }

    public static void copy(String srcPath, String destPath) {
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
