package Base;

/**
 * 测试匿名内部类
 */
public class AnonymousInnerClass {
    public static void InnerClass(AA a){
        System.out.println("###############");
        a.aa();
    }

    public static void main(String[] args) {
        /**
         * 如果想要使用InnerClass()方法，必须要实现AA接口的实现类
         * 那么就出现了两种方法：
         * 1.首先创建实现AA接口的实现类，再去InnerClass()方法里面new一个实现类
         * 2.匿名内部类
         * 此处只是定义，不是调用，调用在上面的InnerClass()方法里面
         */
        AnonymousInnerClass.InnerClass(new BB());
        AnonymousInnerClass.InnerClass(new AA() {
            @Override
            public void aa() {
                System.out.println("我是创建的匿名内部类实现的方法");
            }
        });
    }
}
interface AA{
    void aa();
}
class BB implements AA{
    @Override
    public void aa() {
        System.out.println("我的作用是实现AA接口的实现类");
    }
}