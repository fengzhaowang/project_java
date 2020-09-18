package File;

import java.io.File;

public class FileDemo01 {
    public static void main(String[] args) {
        String path = "D:/idea/project_java/src/File/img/aaa.jpg";

        //1、直接使用路径构建File对象
        File src = new File(path);
        System.out.println(src.length());

        //2、父子构建
        src = new File("D:/idea/project_java/src/File/img","aaa.jpg");
        System.out.println(src.length());
        src = new File("D:/idea/project_java","src/File/img/aaa.jpg");
        System.out.println(src.length());

        //3、父对象子名称
        src = new File(new File("D:/idea/project_java/src/File/img"),"aaa.jpg");
        System.out.println(src.length());
    }
}
