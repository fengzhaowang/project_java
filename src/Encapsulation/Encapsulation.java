package Encapsulation;

public class Encapsulation {
    public static void main(String[] args) {
        Human2 h = new Human2();
        //h.age = 13;//此处报错，还是因为使用private修饰的变量，其他的class不能使用或调用，如果想要使用该变量，那么就去除变量前面的private
        h.name = "张三";//此处可以使用，因为此方法与name属性所在的方法属于同一个包
    }
}
class Human{
    private int age;//private 私有
    String name;
    protected int height;//可以被不同包的子类进行调用，但不能被其他不相关的类进行调用
     void sayAge(){
        /**
         * 此处可以使用age，因为用private修饰的变量同class可以使用并调用，如果想要使用该变量，那么就去除变量前面的private
         */
        age = 18;
        System.out.println(age);
    }
}
class Boy extends Human {
    /**
     * Boy拥有了Human的一切，包括私有的age，但不能使用，因为不可见
     * 子类无法使用父类的私有属性和方法
     */
    void sayHello() {
        /**
         * 此处报错，因为用private修饰的变量不能让其他class调用，如果想要使用该变量，那么就去除变量前面的private
         */
        //age = 18;
        //System.out.println(age);
        height = 180;//此处可以调用被protected修饰的height变量，因为此类是Human的子类
    }

}