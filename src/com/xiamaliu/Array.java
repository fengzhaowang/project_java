package com.xiamaliu;

public class Array {
    public static void main(String[] args) {
        int[] arr01 = new int[10];//后面的new是定好数组的长度
        String arr02[] = new String[5];
        for(int i = 0; i < 10; i++){
            arr01[i] = 10*i;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(arr01[i]);
        }
        Users[] user = new Users[3];
        user[0] = new Users(1001,"张三");
        user[1] = new Users(1002,"李四");
        user[2] = new Users(1003,"王五");
        for(int i = 0 ;i < 3;i++){
            System.out.println("学号："+user[i].getId()+",姓名："+user[i].getName());
        }
    }
}
class Users{
    private int id;
    private String name;
    //生成构造器
    public Users(int id, String name) {
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
