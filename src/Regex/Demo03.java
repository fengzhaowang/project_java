package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 14 : 46
 * @Description: 测试正则表达式的替换操作
 */
@SuppressWarnings("all")
public class Demo03 {
    public static void main(String[] args) {
        //在这个字符串：adhgadh5616561，是否符合指定的正则表达式：\w+
        //表达式对象
        Pattern p = Pattern.compile("[0-9]");
        //创建Matcher对象
        Matcher m = p.matcher("adsa546***adf411**adf1545");

        //替换
        String newStr = m.replaceAll("#");
        System.out.println(newStr);
    }
}
