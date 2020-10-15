package Factory.FactoryMethod;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 09 : 18
 * @Description: 工厂方法模式
 * 只需要创构建实体类和接口就可以进行调用，不需要修改代码，只需要创建文件即可使用
 * 扩展的时候更符合OCP开闭原则
 * 缺点：增加的文件变多
 */
public abstract class Client {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().creatCar();
        Car c2 = new BydFactory().creatCar();
        Car c3 = new BenzFactory().creatCar();
        c1.run();
    }
}
