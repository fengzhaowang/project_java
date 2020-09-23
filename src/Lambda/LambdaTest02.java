package Lambda;

/**
 * lambda + 传参
 */
public class LambdaTest02 {
    public static void main(String[] args) {
        //外部类
        Love love1 = new Love();
        love1.lambda("外部类");

        //lambda匿名内部类
        ILove love2 = (String a) -> {
            System.out.println("我是 ==> " + a);
        };
        love2.lambda("lambda匿名内部类");

        //简化后的lambda匿名内部类（去除参数类型）
        ILove love3 = (a) -> {
            System.out.println("我是 ==> " + a);
        };
        love3.lambda("去除参数类型的lambda匿名内部类");

        //只有一个参数，括号可以省略
        ILove love4 = a -> {
            System.out.println("我是 ==> " + a);
        };
        love4.lambda("去除参数类型和括号的lambda匿名内部类");

        //如果花括号里面只有一句话，则花括号也可以省略
        ILove love5 = a -> System.out.println("我是 ==> " + a);
        love5.lambda("去除参数类型和花括号以及括号的lambda匿名内部类");
    }
}

interface ILove{
    void lambda(String a);
}

//外部类
class Love implements ILove{
    @Override
    public void lambda(String a) {
        System.out.println("我是 ==> " + a);
    }
}
