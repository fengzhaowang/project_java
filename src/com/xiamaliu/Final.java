package com.xiamaliu;

public class Final {
    public static void main(String[] args) {

    }
}

/**
 * 类添加上final之后，后面就无法继承
 * 方法public后面加final，则后面的类不能重写此方法
 * 变量前面添加final，所有的地方都不能对该变量赋值
 */
/*final*/ class Animals3{
    /*final*/ int id = 10;
    public /*final*/ void shout2(){
        System.out.println("我是动物！！");
    }
}
class Dog3 extends Animals3{
    @Override
    public void shout2(){
        id = 20;
        System.out.println("汪汪汪.....");
    }
}
class Cat3 extends Animals3{
    @Override
    public void shout2(){
        System.out.println("喵喵喵.....");
    }
}