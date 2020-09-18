package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节输入流：第一个程序：理解操作步骤 标准
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest02 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        FileInputStream is = null;
        try {
            is = new FileInputStream(src);
            //3、操作（读取）
            int temp;
            while ((temp=is.read()) != -1){
                System.out.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                //is为null  说明没有使用到is
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
