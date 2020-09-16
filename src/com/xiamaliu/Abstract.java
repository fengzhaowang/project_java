package com.xiamaliu;

/**
 * 抽象类存在的意义：就是给子类提供统一的、规范的模板，子类必须实现相关的抽象方法！
 * 1.有抽象方法的类只能定义成抽象类
 * 2.抽象类不能实例化，即不能用new来实例化抽象类
 * 3.抽象类可以包含属性、方法、构造方法。但是构造方法不能用new实例，只能用来被子类调用
 * 4.抽象类只能用来被继承
 * 5.抽象方法必须被子类实现
 */
public abstract class Abstract {
    /**
     * abstract为抽象方法
     * 子方法含有abstract，父类必须也要有abstract
     * 如果想要继承此类，子类必须要实现该父类里面没有实现的方法
     * 第一：没有实现  第二：子类必须实现
     */
    abstract public void shouts();
    //可以通过abstract可以控制子类
    //abstract public int shouts();//子类必须全部返回int类型
    //abstract public String shouts();//子类必须返回String类型
    //abstract public boolean shouts();//子类必须返回boolean类型

    public void run(){
        System.out.println("跑啊！");
    }

    public static void main(Strings[] args) {
        //Abstract a = new Abstract();//这样会报错，不能实例化对象，也就是不能new
        //但是可以用来new子类对象
        Abstract a = new Animalses();
        a.shouts();
        a.run();
        Integer i;//此处的Integer方法就是被抽象化的方法，可以通过按住Ctrl键点击查看
    }
}
class Animalses extends Abstract{

    @Override
    public void shouts() {
        System.out.println("嘿嘿嘿....");
    }
}
