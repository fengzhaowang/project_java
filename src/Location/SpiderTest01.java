package Location;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 25 19 : 51
 * @Description: 网络爬虫的原理
 */
public class SpiderTest01 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url = new URL("https://www.jd.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String msg = null;
        while (null != (msg=reader.readLine())){
            System.out.println(msg);
        }
        //分析
        //处理。。。。
    }
}
