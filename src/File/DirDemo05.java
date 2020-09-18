package File;

import java.io.File;

/**
 * 使用对象：统计文件夹及文件的总大小
 */
public class DirDemo05 {
    public static void main(String[] args) {
        DirCount dirCount = new DirCount("D:/idea/project_java/src/File");
        System.out.println(dirCount.getLen());
        System.out.println("文件的个数：" + dirCount.getFileSize());
        System.out.println("文件夹的个数：" + dirCount.getDirSize());

        DirCount dirCount2 = new DirCount("D:/idea/project_java/src/Node");
        System.out.println(dirCount2.getLen());
        System.out.println("文件的个数：" + dirCount2.getFileSize());
        System.out.println("文件夹的个数：" + dirCount2.getDirSize());
    }
}
class DirCount{
    private long len;
    private String dirPath;
    private File srcs;
    private int fileSize = 0;
    private int dirSize = 0;

    public DirCount(){
    }

    public DirCount(String dirPath) {
        this.dirPath = dirPath;
        this.srcs = new File(this.dirPath);
        count(srcs);
    }

    public long getLen() {
        return len;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getDirSize() {
        return dirSize;
    }

    //打印子孙级目录和文件的大小
    private void count(File src){
        if(src != null && src.exists()){
            if(src.isFile()){
                len += src.length();
                this.fileSize++;
            }else{
                for(File f:src.listFiles()){
                    count(f);
                }
                this.dirSize++;
            }
        }else{
            throw new RuntimeException("文件夹或文件不存在！");
        }
    }
}