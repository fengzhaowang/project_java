package IO;

import java.io.*;
import java.net.URL;

public class ConverTest02 {
    public static void main(String[] args) throws IOException {
        /**
         * 使用InputStreamReader是为了统一 字符集
         * 使用BufferedReader是为了增加效率
         */
        try ( BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new URL("https://www.baidu.com").openStream(),"UTF-8"));
              BufferedWriter writer =
                      new BufferedWriter(
                              new OutputStreamWriter(
                                      new FileOutputStream("baidu.html"),"UTF-8"))){
            String msg;
            while ((msg = reader.readLine()) != null){
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
