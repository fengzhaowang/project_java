package File;

import java.io.File;

/**
 * 创建文件夹
 * 1、mkdir()：确保上级目录存在，不存在则创建失败
 * 2、mkdirs（）：上级目录可以不存在，不存在一同创建
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("D:/idea/project_java/src/File/img/images");
        //mkdir创建目录
        boolean mkdir = dir.mkdir();
        System.out.println(mkdir);
        //mkdirs创建目录
        dir = new File("D:/idea/project_java/src/File/img/aaa/images");
        mkdir = dir.mkdirs();
        System.out.println(mkdir);

    }
}
