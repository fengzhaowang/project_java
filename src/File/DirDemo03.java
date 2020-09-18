package File;

import java.io.File;

/**
 * 递归：方法自己调用自己
 * 打印子孙级目录和文件的名称
 */
public class DirDemo03 {
    public static void main(String[] args) {
        File src = new File("D:/idea/project_java/src/File");
        printName(src,0);
    }

    //打印子孙级目录和文件的名称
    public static void printName(File src,int deep){
        //打印前面层次感
        for(int i = 0;i < deep;i++){
            System.out.print("-");
        }
        //打印名称
        System.out.println(src.getName());
        if (src == null || !src.exists()){//递归头
            return;
        }else if(src.isDirectory()){
            //是否是文件夹
            for(File s:src.listFiles()){//递归体
                printName(s,deep+1);
            }
        }else{

        }
    }
}
