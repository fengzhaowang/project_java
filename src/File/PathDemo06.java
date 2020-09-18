package File;

import java.io.File;
import java.io.IOException;

/**
 * 其他信息
 * creatNewFile() : 不存在才创建,存在则返回false
 * delete()：删除已经存在的字符串
 */
public class PathDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("D:/idea/project_java/src/File/img/aaa.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);

        //不会创建文件夹，只会创建没有后缀的文件
        src = new File("D:/idea/project_java/src/File/img");
        flag = src.createNewFile();
        System.out.println(flag);

        //删除
        boolean delete = src.delete();
        System.out.println(delete);

        //补充：con com3....操作系统文件，不能被创建
        src = new File("D:/idea/project_java/src/File/img/con");
        System.out.println(src.createNewFile());
    }
}
