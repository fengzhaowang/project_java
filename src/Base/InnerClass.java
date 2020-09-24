package Base;

/**
 * 非静态内部类
 */
public class InnerClass {
    public static void main(String[] args) {
        //创建外部类对象
        Outher o = new Outher();
        //创建内部类对象
        //依托外部对象
        Outher.Inner inner = new Outher().new Inner();
        inner.show();
    }
}
class Outher{
    private int age = 10;

    public void testOuter(){
        System.out.println("我今年的年龄是："+this.age);
    }
    class Inner{
        int age = 20;
        public void show(){
            int age = 30;
            System.out.println("外部类的成员变量age："+Outher.this.age);//方外外部类成员变量的方式是类名+this+变量名
            System.out.println("内部类的成员变量age："+this.age);
            System.out.println("局部变量age："+age);
        }
    }
}
