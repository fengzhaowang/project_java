package Lambda;

/**
 * lambda推导
 * 保证接口只有一个没有实现的方法
 */
public class LambdaTest01 {
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        //方法内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("我是方法内部类");
            }
        }
        Like3 like3 = new Like3();
        like3.lambda();

        //匿名内部类
        ILike like4 = new ILike(){
            public void lambda() {
                System.out.println("我是匿名内部类");
            }
        };
        like4.lambda();


        //lambda匿名内部类
        ILike like5 = () -> {
            System.out.println("我是lambda匿名内部类");
        };
        like5.lambda();

        //lambda推导必须存在类型
        /*() -> {
            System.out.println("我是lambda匿名内部类");
        }.lambda();*/
    }

    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("我是内部类");
        }
    }
}
interface ILike{
    void lambda();
    //void lambda2();//打开会报错，因为匿名内部类只能实现接口只有一个没有实现的方法
}

//外部类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("我是外部类");
    }
}
