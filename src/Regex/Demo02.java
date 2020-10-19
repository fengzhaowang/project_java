package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 14 : 46
 * @Description: 测试正则表达式的分组处理
 */
@SuppressWarnings("all")
public class Demo02 {
    public static void main(String[] args) {
        //在这个字符串：adhgadh5616561，是否符合指定的正则表达式：\w+
        //表达式对象
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
        //创建Matcher对象
        Matcher m = p.matcher("adsa546***adf411**adf1545");

        //m.group(),m.group(0)匹配整个表达式的子字符串
        //m.group(n)除0之外的数字就代表第几个匹配到的表达式，前提是表达式通过()进行了分组
        while (m.find()){
            System.out.println(m.group(0));//相当于m.group()
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
