package com.xiamaliu;

public interface MyInterface2 {
    public static void main(String[] args) {
        Volant v = new Angel();
        /**
         * v方法里面只有Volant接口里面的方法，并不会出现Honest里面的方法
         * 说明：只会出现父类里面的方法
         */
        v.fly();
        //v.helpOther();//编译器不认识Honest里面的方法，所以不能调用，只认识接口里面的方法

        Honest g = new GoodMan();
        g.helpOther();
    }
}

/**
 * 飞行接口
 */
interface Volant{
    int FLY_HEIGHT = 1000;
    void fly();
}

interface Honest{
    void helpOther();
}
class Angel implements Volant,Honest{//实现类可以实现多个父接口！
    @Override
    public void fly() {
        System.out.println("我可以飞！！");
    }
    @Override
    public void helpOther() {
        System.out.println("喜欢帮助别人！");
    }
}
class GoodMan implements Honest{
    @Override
    public void helpOther() {
        System.out.println("我可以帮助别人！");
    }
}
class Birdman implements Volant{
    @Override
    public void fly() {
        System.out.println("我可以自由的飞！！");
    }
}