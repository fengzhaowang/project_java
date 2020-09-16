package com.xiamaliu;

public class Strings {
    public static void main(String[] args) {
        String str1 = "nihao";
        String str2 = "nihao";
        String str3 = new String("nihao");
        System.out.println(str1.toUpperCase());
        System.out.println(str1 == str2);//系统会把str1和str2放到常量池中，他俩的引用地址都是一样的，所以为true
        System.out.println(str2 == str3);//str3会重新new一个对象，所以str2不能和str3相等，所以为false

        //判断字符串的内容还是得用equals
        System.out.println(str1.equals(str2));//true
        System.out.println(str2.equals(str3));//true
    }
}
