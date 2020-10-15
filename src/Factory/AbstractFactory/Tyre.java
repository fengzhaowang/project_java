package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 51
 * @Description: 轮胎
 *
 */
//抽象产品Abstract Product，顶一个产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品
@SuppressWarnings("all")
public interface Tyre {
    void revolve();
}

//具体产品Concrete Product，实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系
//质量好
class LuxuryTyre implements Tyre{
    @Override
    public void revolve() {
        System.out.println("轮胎转得快！");
    }
}

//质量差
class LowTyre implements Tyre{
    @Override
    public void revolve() {
        System.out.println("轮胎转得慢！");
    }
}