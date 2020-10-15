package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 10 : 04
 * @Description: 抽象工厂模式的主要角色如下：
 * 1、抽象工厂Abstract Factory，提供了创建产品的接口，它包含多个创建产品方法createProduct()，可以创建多个不同等级/种类的产品
 * 2、具体工厂Concrete Factory，主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建
 * 3、抽象产品Abstract Product，顶一个产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品
 * 4、具体产品Concrete Product，实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系
 */
@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) {
        LuxuryCarFactory factory = new LuxuryCarFactory();
        Engine e = factory.creatEngine();
        e.run();
        e.start();
    }
}
