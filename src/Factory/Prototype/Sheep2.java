package Factory.Prototype;

import java.util.Date;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 14 : 09
 * @Description: 测试深复制/深克隆
 * Cloneable里面并没有clone()方法，而是直接调用Object的clone()方法
 */
public class Sheep2 implements Cloneable{
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //直接调用Object的clone()方法
        Object obj = super.clone();

        //添加如下代码实现深克隆（deep clone）
        Sheep2 s = (Sheep2)obj;
        s.birthday = (Date)this.birthday.clone();

        return s;
    }

    public Sheep2() {
    }

    public Sheep2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
