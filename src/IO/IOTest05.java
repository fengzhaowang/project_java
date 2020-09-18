package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流
 * 1、创建源
 * 2、选择流
 * 3、操作（写出内容）
 * 4、释放资源
 */
public class IOTest05 {
    public static void main(String[] args) {
        File dest = new File("dest.txt");
        FileOutputStream os = null;
        try {
            //FileOutputStream默认有两个参数，一个是file对象，一个是Boolean类型，true为追加，false为覆盖
            os = new FileOutputStream(dest,false);
            //3、操作（写出）
            String str = "IO is so easy;";
            byte[] datas = str.getBytes();//字符串 --> 字节数组（编码）
            os.write(datas,0,datas.length);//数据写入
            os.flush();//数据刷新
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
