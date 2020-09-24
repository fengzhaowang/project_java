package Base;

public class Polymorphism2 {
    public static void main(String[] args) {
        Animals a = new Animals();
        animalCry(a);
        /**
         * 对象的转型：只能向上或者向下转型，也就是子类可以转型为父类，父类可以转型为子类，但不能子类转为子类
         */
        Animals d = new Dog2(); //自动向上转型（自动由子类变为父类）
        animalCry(d);
        Animals c = new Cat2();

        Dog2 d1 = (Dog2) d; //强制向下转型
        d1.shout2();

        Dog2 d2 = (Dog2) c;//此处编译不会出错，但是在运行的时候会出错，原因是Dog和Cat同是Animals的子类，他俩是同级，所以不能强制转换
        d2.shout2();

    }
    static void animalCry(Animals a){
        a.shout2();
    }
}
class Animals{
    public void shout2(){
        System.out.println("我是动物！！");
    }
}
class Dog2 extends Animals{
    @Override
    public void shout2(){
        System.out.println("汪汪汪.....");
    }
}
class Cat2 extends Animals{
    @Override
    public void shout2(){
        System.out.println("喵喵喵.....");
    }
}