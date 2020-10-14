package DynamicCompile;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 13 : 51
 * @Description: 反射调用main方法
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        String str = "public class Hi { public static void main(String[] args){System.out.println(\"Hi!!!\");}}";
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("D:/Hi.java"));
        stream.write(str.getBytes(),0,str.getBytes().length);
        stream.flush();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "D:/Hi.java");
        System.out.println(result==0?"编译成功":"编译失败");

        //通过Runtime.getRuntime()运行启动新的进程运行
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp D:/ Hi");
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String info = "";
        while ((info = bufferedReader.readLine())!= null){
            System.out.println(info);
        }
    }
}
