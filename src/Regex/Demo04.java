package Regex;

import java.util.Arrays;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 14 : 46
 * @Description: 测试正则表达式的分割字符串的操作
 */
@SuppressWarnings("all")
public class Demo04 {
    public static void main(String[] args) {
        String str = "a48d4af5asdf46a4dfadf1afds";
        String[] arrs = str.split("\\d+");
        System.out.println(Arrays.toString(arrs));
    }
}
