package File;

import java.io.File;

public class PathDemo01 {
    public static void main(String[] args) {
        String path = "D:/idea/project_java/src/File/img/aaa.jpg";
        System.out.println(File.pathSeparatorChar);

        //1、
        path = "D:\\idea\\project_java\\src\\File\\img\\aaa.jpg";
        System.out.println(path);

        //2、常亮拼接
        path = "D:"+File.separator+"idea"+File.separator+"project_java"+File.separator+"src"+File.separator+"File"+File.separator+"img"+File.separator+"aaa.jpg";
        System.out.println(path);
    }
}
