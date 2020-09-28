package Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 25 19 : 51
 * @Description: 网络爬虫的原理 + 模拟浏览器
 */
public class SpiderTest02 {
    public static void main(String[] args) throws IOException {
        //获取URL
        URL url = new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection coon = (HttpURLConnection)url.openConnection();
        coon.setRequestMethod("GET");
        coon.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.105 Safari/537.36");
        BufferedReader reader = new BufferedReader(new InputStreamReader(coon.getInputStream(), "UTF-8"));
        String msg = null;
        while (null != (msg=reader.readLine())){
            System.out.println(msg);
        }
        //分析
        //处理。。。。
    }
}
