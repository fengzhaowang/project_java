package com.xiamaliu;

public class Static {
    int id;
    String name;
    String pwd;

    static String company = "北京尚学堂";

    public Static(int id,String name){
        this.id = id;
        this.name = name;
    }

    public void login(){
        printCompany();
        System.out.println("登录："+name);
    }

    public static void printCompany() {
        //login();//调用非静态成员，编译会报错
        System.out.println(company);
    }

    public static void main(String[] args) {
        Static S = new Static(101,"高小七");
        Static.printCompany();
        Static.company = "北京阿里爷爷";
        Static.printCompany();
    }
}
