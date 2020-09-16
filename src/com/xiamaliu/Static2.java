package com.xiamaliu;

public class Static2 {
    int id;
    String name;
    String pwd;

    static String company;

    //先加载类，再加载构造器，所以先加载static代码块，再加载main函数等构造器
    static {
        System.out.println("执行类初始化工作");
        company = "北京尚学堂";
        printCompany();
    }

    public static void printCompany() {
        System.out.println(company);
    }

    public static void main(String[] args) {
        Static2 s = null;
    }
}
