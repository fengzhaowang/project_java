package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 58
 * @Description: 抽象工厂Abstract Factory，提供了创建产品的接口，它包含多个创建产品方法createProduct()，可以创建多个不同等级/种类的产品
 */
@SuppressWarnings("all")
public interface CarFactory {
    Engine creatEngine();
    Seat creatSeat();
    Tyre creatTyre();
}
