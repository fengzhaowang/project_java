package IO;

import java.io.*;

/**
 * 字节输入流：十遍练习
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */
public class IOTest03 {
    public static void main(String[] args) {
        ten();
    }

    public static void one() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作(读取)
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void two() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作（读取）
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void three() {
        //1、创建源
        File file = new File("abc.txt");
        //2、选择流
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void four() {
        //1、创建源
        File file = new File("abc.txt");
        //2、选择流
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void five() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void six() {
        //1、创建源
        File file = new File("abc.txt");
        //2、选择流
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void seven() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void eight() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void nine() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void ten() {
        //1、创建源
        File file = new File("abc.txt");
        FileInputStream fileInputStream = null;
        try {
            //2、选择流
            fileInputStream = new FileInputStream(file);
            //3、操作
            int temp;
            while ((temp = fileInputStream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ///4、释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
