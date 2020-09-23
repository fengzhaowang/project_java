package IO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 自节数组输出流  ByteArrayOutputStream
 *
 * 1、存储在内存中
 * 2、字节数组流不用释放，close为空方法，只是为了统一
 * 3、任何东西都能转成字节数组
 * 4、方便网络进行传输
 *
 *
 * 1、创建源：内部维护
 * 2、选择流：不关联源
 * 3、操作（写出内容）
 * 4、释放资源：可以不释放资源
 *
 * 获取数据：toByteArray()
 */
public class IOTest11 {
    public static void main(String[] args) {
        //1、创建源
        byte[] dest = null;
        //2、选择流
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            //3、操作（写出）
            String str = "talk is cheap show me the code";
            byte[] datas = str.getBytes();//字符串 --> 字节数组（编码）
            baos.write(datas,0,datas.length);//数据写入
            baos.flush();//数据刷新
            //获取数据
            dest = baos.toByteArray();
            System.out.println(dest.length + "---->" + new String(dest,0,dest.length));
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(baos != null){
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
