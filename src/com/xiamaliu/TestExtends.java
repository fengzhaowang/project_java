package com.xiamaliu;

/**
 * 继承：extends+类名
 */
public class TestExtends {
    public static void main(Strings[] args) {
        Student student = new Student();
        student.name = "张三";
        student.height = 170;
        student.major = "web前端基础";
        student.study();

        System.out.println(student instanceof Student);
        System.out.println(student instanceof Person);
    }
}
class Person{
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会！");
    }
}
class Student extends Person{
    /**
     * 此类和Person类具有相同的属性和方法
     * 可以通过继承来继承Person里面的属性和方法
     * 如果使用继承，则被继承的类里面所有的属性与方法全部可以在此类中使用
     * 使用方法就是在类的名称后面添加extends+类名
     */
    /*String name;
    int height;*/
    String major;
    public void study(){
        System.out.println("学习两小时！");
        /**
         * 此处可以使用Person类里面的属性
         */
        System.out.println("姓名："+name+";身高："+height+";学科："+major);
    }
    /*public void rest(){
        System.out.println("休息一会！");
    }*/
}
