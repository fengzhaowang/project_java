package com.xiamaliu;

public class This {
    int a,b,c;

    This(int a,int b){
        this.a = a;
        this.b = b;
    }
    //构造器不能直接调用另一个构造器，也不能用this.只能用this()加上参数来调用某个构造器
    This(int a,int b,int c){
        this(a,b);
        this.c = c;
    }

    void sing(){

    }

    void eat(){
        this.sing();
        System.out.println("你妈妈喊你回家吃饭啊！！");
    }
    //static方法中不能使用this
    public static void main(String[] args) {
        This hi = new This(2,3);
        hi.eat();
    }
}
