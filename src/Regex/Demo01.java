package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 14 : 46
 * @Description: 测试正则表达式的基本用法
 */
public class Demo01 {
    public static void main(String[] args) {
        //在这个字符串：adhgadh5616561，是否符合指定的正则表达式：\w+
        //表达式对象
        Pattern p = Pattern.compile("\\w+");
        //创建Matcher对象
        Matcher m = p.matcher("adhgadh5616561");
        Matcher m2 = p.matcher("adhgadh5616561&&adh5616");
        //尝试将整个字符序列与该模式进行匹配
        boolean yesorno = m.matches();
        System.out.println(yesorno);

        //该方法扫描输入的序列，查找与该模式匹配的下一个子序列，可以一直找下去，但是出现几次find，就会查找了几次
        //boolean yesorno2 = m2.find();

        //找出并打印出来
        //System.out.println(m2.find());
        //System.out.println(m.group());
        //System.out.println(m2.find());
        //System.out.println(m2.group());

        while (m2.find()){
            System.out.println(m2.group());
        }
    }
}
