package Factory.Prototype;

import java.util.Date;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 14 : 12
 * @Description: 测试原型模式（浅克隆/浅复制）
 * 克隆出来的对象的值与原来的值一模一样，但对象的地址不同
 * 此时称为浅克隆的意思是将s1的Date的引用地址赋值给了s2，当Date的值改变时，s2的值也会改变
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(1635558826585L);
        Sheep s1 = new Sheep("多利", date);
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        Sheep s2 = (Sheep) s1.clone();

        date.setTime(46565565116L);
        System.out.println("改变之后的日期："+s1.getBirthday());

        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
