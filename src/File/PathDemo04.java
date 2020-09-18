package File;

import java.io.File;

/**
 * 名称或路径
 * getName()
 * getPath()
 * getAbsolutePath()
 * getParent()
 */
public class PathDemo04 {
    public static void main(String[] args) {
        File src = new File("img/aaa.jpg");
        System.out.println(src.getAbsolutePath());
        System.out.println("是否存在："+src.exists());
        System.out.println("是否是文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());

        System.out.println("-------------------");

        src = new File("aaa.jpg");
        System.out.println(src.getAbsolutePath());
        System.out.println("是否存在："+src.exists());
        System.out.println("是否是文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());

        System.out.println("-------------------");

        src = new File("img");
        System.out.println(src.getAbsolutePath());
        System.out.println("是否存在："+src.exists());
        System.out.println("是否是文件："+src.isFile());
        System.out.println("是否是文件夹："+src.isDirectory());

        System.out.println("-------------------");

        src = new File("xxx");
        if(src == null || !src.exists()){
            System.out.println("文件不存在");
        }else{
            if(src.isFile()){
                System.out.println("文件操作");
            }else{
                System.out.println("文件夹操作");
            }
        }
    }
}
