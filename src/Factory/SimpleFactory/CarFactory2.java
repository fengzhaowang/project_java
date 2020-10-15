package Factory.SimpleFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 08 : 44
 * @Description: 简单工厂类
 */
public abstract class CarFactory2 {
    public static Car creatAudi(){
        return new Audi();
    }
    public static Car creatByd(){
        return new Byd();
    }
}
