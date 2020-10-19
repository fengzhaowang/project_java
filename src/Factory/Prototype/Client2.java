package Factory.Prototype;

import java.util.Date;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 14 : 24
 * @Description: 测试原型模式（深克隆/深复制）
 */
public class Client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(1635558826585L);
        Sheep2 s1 = new Sheep2("多利", date);
        Sheep2 s2 = (Sheep2) s1.clone();
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        date.setTime(46565565116L);
        System.out.println("改变之后的日期："+s1.getBirthday());

        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
