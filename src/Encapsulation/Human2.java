package Encapsulation;

public class Human2 {
    private int age;//private 私有
    String name;//此属性只能被本包下面的类访问
    protected int height;//可以被不同包的子类进行调用，但不能被其他不相关的类进行调用
    void sayAge(){
        /**
         * 此处可以使用age，因为用private修饰的变量同class可以使用并调用，如果想要使用该变量，那么就去除变量前面的private
         */
        age = 18;
        System.out.println(age);
    }

    /**
     * 此方法被public修饰，所有的地方或所有的类都可以进行调用此方法
     */
    public void sayGodBye(){
        System.out.println("再见!");
    }
}
