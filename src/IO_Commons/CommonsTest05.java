package IO_Commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 拷贝
 */
public class CommonsTest05 {
    public static void main(String[] args) throws IOException {
       //复制文件
        // FileUtils.copyFile(new File(),new File());
        //复制文件到目录
        // FileUtils.copyFile(new File(),new File());
        //复制目录到目录
        //FileUtils.copyDirectoryToDirectory(new File("D:\\idea\\project_java\\src\\IO_Commons"),new File("D:\\idea\\project_java\\src\\IO_Commons2"));
        //复制目录中的文件到目录
        //FileUtils.copyDirectory(new File("D:\\idea\\project_java\\src\\IO_Commons"),new File("D:\\idea\\project_java\\src\\IO_Commons2"));
        //拷贝URL内容
        //String url = "https://commons.apache.org/proper/commons-io/images/commons-logo.png";
        //FileUtils.copyURLToFile(new URL(url),new File("commonsCopy.png"));
        //获取url字符串内容
        String s = IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
        System.out.println(s);
    }
}
