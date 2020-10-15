package Factory.SimpleFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 08 : 36
 * @Description: 测试在没有工厂模式的情况下
 * 对于新增的产品无能为力，不修改代码的话，是无法扩展的
 */
public class Client01 {
    public static void main(String[] args) {
        Car c1 = new Audi();
        Car c2 = new Byd();
        c1.run();
        c2.run();
    }
}
