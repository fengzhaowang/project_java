package Base;

public class TestSuper02 {
    public static void main(String[] args) {
        System.out.println("开始创建一个ChildClass2对象.....");
        new ChildClass2();
        /**
         * 按理说应该输出的是：
         * 开始创建一个ChildClass2对象.....
         * 创建ChildClass2
         *
         * 则现实输出的是：
         * 开始创建一个ChildClass2对象.....
         * 创建FatherClass2
         * 创建ChildClass2
         *
         *原因：所有的构造方法的第一句都是super();子类构造器首先会调用父类的构造器
         * 子类会继承父类的构造器，父类会继承Object的构造器
         * 从而进行调用父类，而父类也是调用父类的方法，即Object，然后再一层一层的往下推；
         * 所以才会出现上方情况，打印了三句
         */
    }
}
class FatherClass2{
    public FatherClass2(){
        System.out.println("创建FatherClass2");
    }
}
class ChildClass2 extends FatherClass2{
    public ChildClass2(){
        System.out.println("创建ChildClass2");
    }
}