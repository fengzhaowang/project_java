package File;

import java.io.File;

/**
 * 列出下一级
 * 1、list()：列出下级名称
 * 2、listFiles()：列出下级File对象
 * 3、listRots()：列出所有的盘符
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File("D:/idea/project_java/src");

        //列出下级名称
        String[] list = dir.list();
        for (String s:list){
            System.out.print(s + "，");
        }
        System.out.println();
        System.out.println("-----------------------");

        //列出下级对象
        File[] files = dir.listFiles();
        for (File ss:files){
            System.out.println(ss.getAbsolutePath());
        }

        System.out.println("-----------------------");

        //列出所有盘符
        File[] roots = dir.listRoots();
        for (File sss:roots){
            System.out.println(sss.getAbsolutePath());
        }
    }
}
