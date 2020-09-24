package Base;

public interface MyInterface {
    /**
     * 常量：接口中的属性只能常量，总是public static final修饰，不写系统会自动添加
     * 方法：接口中的方法只能是public abstract，省略的罗，系统会自动添加
     */
    /*public static final*/ int MAX_AGE = 100;
    /*public abstract*/ void test01();
}

/**
 * implements是实现接口
 */
class MyClass implements MyInterface{
    /**
     * 在此类中，因为调用了接口，所以必须要实现重写之前接口里面的方法
     * 必须要重写父类里面定义的抽象类
     */
    @Override
    public void test01() {
        System.out.println(MAX_AGE);//父类里面的常量也是可以使用的
        System.out.println("MyClass");
    }
}