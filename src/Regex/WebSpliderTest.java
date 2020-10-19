package Regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 15 : 15
 * @Description: todo
 */
public class WebSpliderTest {
    public static void main(String[] args) {
        String str = getURLContene("https://www.163.com");
        //System.out.println(str);
        //Pattern p = Pattern.compile("href=\"(http.+?)\"");
        //Matcher m = p.matcher(str);
        //while (m.find()){
        //    System.out.println(m.group(1));
        //}
        List<String> matherSubstrs = getMatherSubstrs(str, "href=\"([\\w\\s./:]+?)\"");
        for (String s:matherSubstrs){
            System.out.println(s);
        }

    }
    public static String getURLContene(String urlStr){
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("GBK")));
            String temp = "";
            while ((temp=reader.readLine())!= null){
                sb.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static List<String> getMatherSubstrs(String destStr,String regexStr){
        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(destStr);
        List<String> resule = new ArrayList<>();
        while (m.find()){
            resule.add(m.group(1));
        }
        return resule;
    }
}
