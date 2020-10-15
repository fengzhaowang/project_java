package Factory.SimpleFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 08 : 36
 * @Description: 简单工厂情况下
 * 对于新增的产品无能为力，不修改代码的话，是无法扩展的
 */
public class Client02 {
    public static void main(String[] args) {
        Car c1 = CarFactory.creatCar("奥迪");
        Car c2 = CarFactory.creatCar("比亚迪");
        c1.run();
        c2.run();
    }
}
