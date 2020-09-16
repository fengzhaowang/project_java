package com.xiamaliu;

public class TestSuper01 {
    public static void main(String[] args) {
        new ChildClass().f();
    }
}
class FatherClass{
    public int value;
    public void f(){
        value = 100;
        System.out.println("FatherClass.value="+value);
    }
}
class ChildClass extends FatherClass{
    public int value;
    @Override
    public void f(){
        super.f();//调用父类的f()方法，进行把100和字符串进行打印
        value = 200;//重新给value赋值
        System.out.println("ChildClass.value="+value);//打印当前的字符串与value
        System.out.println(value);//打印当前的value
        System.out.println(super.value);//打印父类里面的字符串value，100
    }
}