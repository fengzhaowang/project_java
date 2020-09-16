package com.xiamaliu;

public class JavaBean {
    private int id;
    private String name;
    private int age;
    private String sex;
    private boolean flag;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        /**
         * 在get或者set方法内可以进行对参数的判断
         */
        if (age >= 1 && age <= 130){
            this.age = age;
        }else{
            System.out.println("请输入正常的年龄！");
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
