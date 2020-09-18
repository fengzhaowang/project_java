package File;

import java.io.File;

/**
 * 构建File对象
 * 相对路径与绝对路径
 * 1）、存在盘符：绝对路径
 * 2）、不存在盘符：相对路径  相对于当前目录，user.dir
 */
public class PathDemo02 {
    public static void main(String[] args) {
        String path = "D:/idea/project_java/src/File/img/aaa.jpg";

        //绝对路径
        File src = new File(path);
        System.out.println(src.getAbsolutePath());

        //相对路径
        System.out.println(System.getProperty("user.dir"));
        src = new File("aaa.jpg");
        System.out.println(src.getAbsolutePath());

        //构建一个不存在的文件
        src = new File("aaa2.jpg");
        System.out.println(src.getAbsolutePath());
    }
}
