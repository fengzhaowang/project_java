package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流：第一个程序：理解操作步骤
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        try {
            FileInputStream is = new FileInputStream(src);
            //3、操作（读取）
            int data1 = is.read();//第一个数据 h
            int data2 = is.read();//第二个数据 e
            int data3 = is.read();//第三个数据 l
            int data4 = is.read();//不是数据，文件的末尾返回-1
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println(data4);
            //4、释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
