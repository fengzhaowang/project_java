package Factory.FactoryMethod;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 16
 * @Description: todo
 */
public class AudiFactory implements CarFactory{
    @Override
    public Car creatCar() {
        return new Audi();
    }
}
