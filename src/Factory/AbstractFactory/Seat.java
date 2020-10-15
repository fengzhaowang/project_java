package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 53
 * @Description: 座椅
 *
 */

//抽象产品Abstract Product，顶一个产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品
@SuppressWarnings("all")
public interface Seat {
    void message();
}

//具体产品Concrete Product，实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系

class LuxurySeat implements Seat{
    @Override
    public void message() {
        System.out.println("坐的舒服！");
    }
}
class LowSeat implements Seat{
    @Override
    public void message() {
        System.out.println("坐的不舒服！");
    }
}
