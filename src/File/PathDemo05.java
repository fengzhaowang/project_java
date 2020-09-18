package File;

import java.io.File;

/**
 * 其他信息
 * length()：文件的字节数（long）
 */
public class PathDemo05 {
    public static void main(String[] args) {
        File src = new File("D:/idea/project_java/src/File/img/aaa.jpg");
        System.out.println("长度："+src.length());

        src = new File("D:/idea/project_java/src/File/img");
        System.out.println("文件夹长度："+src.length());
    }
}
