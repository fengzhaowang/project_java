package Decorate;

/**
 * 模拟咖啡
 * 1、抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2、具体组件：需要装饰的对象
 * 3、抽象装饰类：包含了对抽象组件的引用以及装饰着共有的方法
 * 4、具体装饰类：被装饰得对象
 */
public class DecorateTest02 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink sugar = new sugar(coffee);//装饰类
        System.out.println(sugar.info() + "--->" + sugar.cost());
        Drink milk = new Milk(coffee);//装饰类
        System.out.println(milk.info() + "--->" + milk.cost());
        milk = new Milk(sugar);//装饰类
        System.out.println(milk.info() + "--->" + milk.cost());
    }
}
//抽象组件
interface Drink{
    double cost();//费用
    String info();//说明
}
//具体组件
class Coffee implements Drink{

    private String name = "原味咖啡";
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}
//抽象装饰类
//如果一个方法使用 abstract 来修饰，则说明该方法是抽象方法，抽象方法只有声明没有实现。
// 需要注意的是 abstract 关键字只能用于普通方法，不能用于 static 方法或者构造方法中。

abstract class Decorate implements Drink{
    //对抽象组件的引用
    private Drink drink;
    //构造器
    Decorate(Drink drink){
        this.drink = drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}
//具体装饰类
class Milk extends Decorate{

    Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info() + "加入了牛奶";
    }
}
class sugar extends Decorate{

    sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info() + "加入了糖";
    }
}