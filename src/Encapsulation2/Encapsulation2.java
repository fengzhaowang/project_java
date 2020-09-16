package Encapsulation2;

import Encapsulation.Human2;

public class Encapsulation2 {
    public static void main(String[] args) {
        Human2 h = new Human2();
        //h.name = "张三";//报错，name为default属性，不能被不同包的类访问
        //h.height = 180;//此处不能调用被protected修饰的变量，只能是子类才能调用或使用
    }
}
class Girl extends Human2{
    void sayGood(){
        height = 180;//此处可以调用Human2里面被protected修饰的height属性，因为他是Human2的子类
    }
}
