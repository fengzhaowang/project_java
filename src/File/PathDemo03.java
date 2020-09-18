package File;

import java.io.File;

/**
 * 名称或路径
 * getName()
 * getPath()  相对路径返回相对路径、绝对路径返回绝对路径
 * getAbsolutePath() 返回绝对路径
 * getParent()
 */
public class PathDemo03 {
    public static void main(String[] args) {
        //绝对路径
        File src = new File("D:/idea/project_java/src/File/img/aaa.jpg");

        //基本信息
        System.out.println("名称："+src.getName());
        System.out.println("路径："+src.getPath());
        System.out.println("绝对路径："+src.getAbsolutePath());
        System.out.println("父路径："+src.getParent());
        System.out.println("父对象："+src.getParentFile().getName());
    }
}
