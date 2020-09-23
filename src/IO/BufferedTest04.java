package IO;

import java.io.*;

/**
 * 字符缓冲流：
 */
public class BufferedTest04 {
    public static void main(String[] args) {
        //1、创建源
        File file = new File("dest.txt");
        BufferedWriter writer = null;
        try {
            //2、选择流
            writer = new BufferedWriter(new FileWriter(file,true));
            //3、操作(写入)
            writer.newLine();//换行
            writer.append("IO is so easy;");
            writer.newLine();//换行
            writer.append("我们能改变你的生活，但改变命运的只有你自己；");
            writer.flush();//刷新
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
