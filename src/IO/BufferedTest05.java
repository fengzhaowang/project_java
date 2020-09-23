package IO;

import java.io.*;

/**
 * 纯文本拷贝使用BufferedReader、BufferedWriter
 */
public class BufferedTest05 {
    public static void main(String[] args) {
        copy02("abc.txt","abc-copy.txt");
    }

    public static void copy02(String srcPath, String destPath) {
        //创建源
        File in = new File(srcPath);
        File out = new File(destPath);
        /**
         * 遇到Reader就要习惯于添加BufferedReader和BufferedWriter，分别为成行读取和成行输出，增加效率
         */
        try (BufferedReader fileInputStream = new BufferedReader(new FileReader(in));
             BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(out));){
            String line = null;
            while ((line = fileInputStream.readLine()) != null) {
                fileOutputStream.write(line);//逐行写出
                fileOutputStream.newLine();
            }
            //刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
