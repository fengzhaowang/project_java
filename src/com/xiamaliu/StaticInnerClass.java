package com.xiamaliu;

/**
 * 静态内部类
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        //创建内部静态类对象
        //不依托外部对象
        Outer2.Inner2 inner = new Outer2.Inner2();
        inner.show2();
    }
}
class Outer2{
    private int age = 10;
    public void show(){
        System.out.println(age);
    }
    static class Inner2{
        int age = 20;
        public void show2(){
            int age = 30;
            //如果想要访问外部类的属性，只能进行创建对象，再去访问他的属性与属性值
            Outer2 o = new Outer2();
            System.out.println("外部类的成员变量age："+o.age);
            //访问本静态类的属性与访问本方法的属性与属性值，与其他非静态类的方法相同
            System.out.println("内部类的成员变量age："+this.age);
            System.out.println("局部变量age："+age);
        }
    }
}