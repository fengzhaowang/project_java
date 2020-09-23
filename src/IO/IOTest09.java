package IO;

import java.io.*;

/**
 * 文件字符输出流：
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest09 {
    public static void main(String[] args) {
        //1、创建源
        File file = new File("dest.txt");
        Writer writer = null;
        try {
            //2、选择流
            writer = new FileWriter(file, true);
            //3、操作(写入)

            //写法一：
            //String str = "IO is so easy;我们能改变你的生活，但改变命运的只有你自己；";//设置写入文本
            //char[] datas = str.toCharArray();//字符串 --> 字符数组
            //writer.write(datas, 0, datas.length);//写入
            //写法二：
            //String str = "IO is so easy;我们能改变你的生活，但改变命运的只有你自己；";
            //writer.write(str);
            //writer.write("我是实习生！");
            //writer.write("我要努力！");
            //writer.write(str);//写入
            //写法三：
            writer.append("IO is so easy;\r\n").append("我们能改变你的生活，但改变命运的只有你自己；");

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
