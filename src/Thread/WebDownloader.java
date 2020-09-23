package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载图片
 */
public class WebDownloader {
    /**
     * 下载
     * @param url
     * @param name
     */
    public void downLoad(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("不合法url");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件目录找不到");
        }
    }
}
