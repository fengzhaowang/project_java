package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 51
 * @Description: 发动机
 */
@SuppressWarnings("all")
//象产品Abstract Product，顶一个产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品
public interface Engine {
    void run();
    void start();
}

//具体产品Concrete Product，实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系

//质量好
class LuxuryEngine implements Engine{
    @Override
    public void run() {
        System.out.println("好发动机转得快！");
    }
    @Override
    public void start() {
        System.out.println("启动快，可以自动启停！");
    }
}

//质量差
class LowEngine implements Engine{
    @Override
    public void run() {
        System.out.println("坏发动机转得慢！");
    }
    @Override
    public void start() {
        System.out.println("启动慢！");
    }
}