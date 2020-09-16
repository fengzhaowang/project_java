package com.xiamaliu;

import java.util.Objects;

public class TestEquals {
    public static void main(String[] args) {
        Object obj;
        /**
         * String里面也对equals方法进行了重写
         */
        String str;

        User u1 = new User(1000,"张三","123456");
        User u2 = new User(1000,"张四","123456");

        System.out.println(u1 == u2);//地址不相同，所哟false
        System.out.println(u1.equals(u2));//内容不一样，所以false
        /**
         * 当进行对equals方法进行对重写后，只对id进行判断
         */
        System.out.println(u1 == u2);//false
        System.out.println(u1.equals(u2));//true
        /**
         * String内部也对equals方法进行了重写
         */
        String s1 = new String("str");
        String s2 = new String("str");
        System.out.println(s1 == s2);//因为对象不同，所以false
        System.out.println(s1.equals(s2));//因为内容相同，所以true
    }
}
class User{
    int id;
    String name;
    String pwd;

    /**
     * 快速生成构造器
     * 1.把光标放在方法内，选择置顶栏中的Code中的Generate中的Constructor
     * 2.按Ctrl+Insert键，选择Generate中的Constructor
     * @param id
     * @param name
     * @param pwd
     */
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    /**
     * 按住Ctrl不放，点击equals，查看equals源代码，复制过来，进行重写
     * 自动生成hashcode或equals方法：
     * 按ALT+Insert，选择equals() and hashcode()
     * 此重写方法的作用是，不想让两个对象进行全部的比较，而是进行id比较
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

}
