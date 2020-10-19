package Factory.Prototype;

import java.util.Date;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 14 : 09
 * @Description: 测试浅复制/浅克隆
 * Cloneable里面并没有clone()方法，而是直接调用Object的clone()方法
 */
public class Sheep implements Cloneable{
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //直接调用Object的clone()方法
        Object clone = super.clone();
        return clone;
    }

    public Sheep() {
    }

    public Sheep(String name, Date birthday) {
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
