package IO_Commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 文件的大小
 */
public class CommonsTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("src/IO_Commons/CommonsTest01.java"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("D:/idea/project_java"));
        System.out.println(len);
    }
}
