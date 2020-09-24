package Base;

public class TestOverrideToString {
    public static void main(Strings[] args) {
        TestOverrideToString to = new TestOverrideToString();
        /**
         * 打印对象也就是相当于打印他的地址，也就是打印to.toString(),现在已经把toString()方法重写了，也就相当于打印public String toString()方法的return的值
         */
        System.out.println(to.toString());

        /**
         * 在Person2中重写了toString()方法，返回的值是return后面的值，通过把下面的内容加载到构造器中，进行赋值，并返回打印
         */
        Person2 p = new Person2("张二",18);
        System.out.println(p.toString());
    }
    @Override
    public String toString(){
        return "现在正是把toString方法重写";
    }
}
/**
 * 重写toString()方法
 */
class Person2{
    String name;
    int age;

    @Override
    public String toString(){
        return name+"，年龄："+age;
    }

    /**
     * 创建构造器
     * @param name
     * @param age
     */
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}