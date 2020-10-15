package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 59
 * @Description: 坏产品实现类
 * 进行坏产品的统一
 * 具体工厂Concrete Factory，主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建
 */
@SuppressWarnings("all")
public class LowCarFactory implements CarFactory{
    @Override
    public Engine creatEngine() {
        return new LowEngine();
    }

    @Override
    public Seat creatSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre creatTyre() {
        return new LowTyre();
    }
}
