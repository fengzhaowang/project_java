package Factory.Bridge;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 08 : 59
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        //创建类型，传入品牌，调用响应方法
        Computer2 c1 = new Laptop2(new Lenovo());
        c1.sale();

        Computer2 c2 = new Desktop2(new Dell());
        c2.sale();
    }
}
