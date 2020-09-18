package IO;

import java.io.*;

/**
 * 字节输出流：五遍练习
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest06 {
    public static void main(String[] args) {
        five();
    }

    public static void one() {
        //1、创建源
        File file = new File("dest.txt");
        FileOutputStream os = null;
        try {
            //2、选择流
            os = new FileOutputStream(file, true);
            //3、操作(写入)
            String str = "IO is so easy;";//设置写入文本
            byte[] datas = str.getBytes();//字符串 --> 字节数组（编码）
            os.write(datas, 0, datas.length);//写入
            os.flush();//刷新
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void two() {
        //1、创建源
        File file = new File("dest.txt");
        FileOutputStream os = null;
        try {
            //2、选择流
            os = new FileOutputStream(file, true);
            //3、操作(写入)
            String str = "IO is so easy;";//要写入的字符串
            byte[] datas = str.getBytes();//字符串 --> 字节数组 （编码）
            os.write(datas, 0, datas.length);//写入
            os.flush();//刷新
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void three() {
        //1、创建源
        File file = new File("dest.txt");
        FileOutputStream os = null;
        try {
            //2、选择流
            os = new FileOutputStream(file, true);
            //3、操作(读取)
            String str = "IO is so easy;\n";
            byte[] datas = str.getBytes();
            os.write(datas, 0, datas.length);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void four() {
        File file = new File("dest.txt");
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file,true);
            String str = "IO is so easy;\n";
            byte[] bytes = str.getBytes();
            os.write(bytes);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void five(){
        File file = new File("dest.txt");
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file, true);
            String str = "IO is so easy;\n";
            byte[] datas = str.getBytes();
            os.write(datas,0,datas.length);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
