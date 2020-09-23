package IO_Commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 写出文件
 */
public class CommonsTest04 {
    public static void main(String[] args) throws IOException {
        /**
         * 第一个参数：文件名字及位置
         * 第二个参数：文件内容
         * 第三个参数：编码格式
         * 第四个参数：是否追加
         */
        FileUtils.write(new File("happy.txt"),"学习是一件伟大的事业\r\n","UTF-8");
        FileUtils.writeStringToFile(new File("happy.txt"),"学习是一件辛苦的事业\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("happy.txt"),"学习是一件幸福的事业\n".getBytes("UTF-8"),true);

        //写出列表
        List<String> datas = new ArrayList<>();
        datas.add("马云");
        datas.add("马化腾");
        datas.add("弼马温");
        /**
         * 第三个参数是间隔符，其他都与上面相同
         */
        FileUtils.writeLines(new File("happy.txt"),datas,"。。。",true);
    }
}
