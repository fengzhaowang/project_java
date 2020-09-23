package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * try...with...resources
 */
public class IOTest13 {
    public static void main(String[] args) {
        copy("a.gif","b.gif");
    }

    public static void copy(String srcPath, String destPath) {
        //创建源
        File in = new File(srcPath);
        File out = new File(destPath);

        /**
         * try...with...resources
         * 将流的声明放入到try后面的括号中，不用使用finally进行close，操作完自动释放资源（1.7以后出现）
         */

        try(FileInputStream fileInputStream = new FileInputStream(in);
            FileOutputStream fileOutputStream = new FileOutputStream(out);) {
            //选择流
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
}
