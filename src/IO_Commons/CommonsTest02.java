package IO_Commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.Collection;

/**
 * 列出子孙集
 */
public class CommonsTest02 {
    public static void main(String[] args) {
        //第一个参数是文件或文件夹的路径，第二个参数是过滤条件，第三个参数是过滤目录的条件
        //EmptyFileFilter.NOT_EMPTY是列出不为空的文件
        Collection<File> files = FileUtils.listFiles(new File("D:/idea/project_java"), EmptyFileFilter.NOT_EMPTY,null);
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }
        System.out.println("-------------------------------------");
        files = FileUtils.listFiles(
                new File("D:/idea/project_java"),
                EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);// DirectoryFileFilter.INSTANCE为列出文件夹里面所有的文件
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }
        System.out.println("-------------------------------------");
        files = FileUtils.listFiles(
                new File("D:/idea/project_java"),
                new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);//new SuffixFileFilter("java")为查看为java后缀的文件
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }
        System.out.println("-------------------------------------");
        files = FileUtils.listFiles(
                new File("D:/idea/project_java"),//FileFilterUtils.or是包含多种条件的过滤器
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), DirectoryFileFilter.INSTANCE);
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }
        System.out.println("-------------------------------------");
        files = FileUtils.listFiles(
                new File("D:/idea/project_java"),//FileFilterUtils.and是满足所有条件的过滤器
                FileFilterUtils.and(new SuffixFileFilter("class"),EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
