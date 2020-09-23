package IO;

import java.io.*;

/**
 * 字符缓冲流：
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        BufferedReader is = null;
        try {
            is = new BufferedReader(new FileReader(src));
            //3、操作（逐行读取）
            String line = null;
            while ((line=is.readLine()) != null){
                System.out.println(line);//逐行打印
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
