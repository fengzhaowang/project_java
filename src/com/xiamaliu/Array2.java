package com.xiamaliu;

public class Array2 {
    public static void main(String[] args) {
        //静态初始化数组
        int[] array = {1,2,3,4,5};
        user2[] user2 = {
                new user2(1001,"张三"),
                new user2(1002,"王五"),
                new user2(1003,"李四")
        };
        //默认初始化数组
        int[] c = new int[3];
        //动态初始化
        int[] d = new int[2];
        d[0] = 1;//赋值
        d[1] = 2;
    }
}
class user2{
    private int id;
    private String name;

    public user2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}