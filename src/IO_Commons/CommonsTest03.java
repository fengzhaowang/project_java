package IO_Commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * 读取内容
 */
public class CommonsTest03 {
    public static void main(String[] args) throws IOException {
        //读取文件
        String s = FileUtils.readFileToString(new File("D:\\idea\\project_java\\src\\IO_Commons\\emp.txt"), "UTF-8");
        System.out.println(s);
        System.out.println("------------------------");
        byte[] bytes = FileUtils.readFileToByteArray(new File("D:\\idea\\project_java\\src\\IO_Commons\\emp.txt"));
        System.out.println(bytes.length);
        System.out.println("------------------------");
        //逐行读取
        List<String> strings = FileUtils.readLines(new File("D:\\idea\\project_java\\src\\IO_Commons\\emp.txt"), "UTF-8");
        for (String s1:strings){
            System.out.println(s1);
        }
        System.out.println("------------------------");
        ///迭代器逐行读取
        LineIterator lineIterator = FileUtils.lineIterator(new File("D:\\idea\\project_java\\src\\IO_Commons\\emp.txt"), "UTF-8");
        while (lineIterator.hasNext()){
            System.out.println(lineIterator.nextLine());
        }
    }
}
