package Factory.AbstractFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 59
 * @Description: 好产品实现类
 * 进行好产品的统一
 * 具体工厂Concrete Factory，主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建
 */
@SuppressWarnings("all")
public class LuxuryCarFactory implements CarFactory{
    @Override
    public Engine creatEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat creatSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre creatTyre() {
        return new LuxuryTyre();
    }
}
