package Factory.Decorator;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 10 : 35
 * @Description: GOF23设计模式-装饰模式
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("基本功能，驾驶-----------");
        Car car = new Car();
        car.move();
        System.out.println("增加新功能，飞行----------");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();
        System.out.println("增加新功能，水里游--------");
        WaterCar waterCar = new WaterCar(car);
        waterCar.move();
        System.out.println("增加新功能，自动驾驶-------");
        AICar aiCar = new AICar(car);
        aiCar.move();
        System.out.println("增加新功能，水路两栖（在水里游添加飞行功能）-------");
        WaterCar waterAndFlyCar = new WaterCar(new FlyCar(car));
        waterAndFlyCar.move();
    }
}
