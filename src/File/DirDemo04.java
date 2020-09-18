package File;

import java.io.File;

/**
 * 统计文件夹及文件的总大小
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("D:/idea/project_java/src/File");
        count(src);
        System.out.println(len);
    }

    private static long len = 0;

    //打印子孙级目录和文件的大小
    public static void count(File src){
        if(src != null && src.exists()){
            if(src.isFile()){
                len += src.length();
            }else{
                for(File f:src.listFiles()){
                    count(f);
                }
            }
        }
    }
}
