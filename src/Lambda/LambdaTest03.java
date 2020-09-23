package Lambda;

/**
 * lambda + 传参
 */
public class LambdaTest03 {
    public static void main(String[] args) {
        IInterest interest = (a,b) -> {
            System.out.println("i like lambda => "+(a+b));
            return a+b;
        };

        int lambda = interest.lambda(100, 200);
        System.out.println(lambda);

        //如果只有一行代码，并且最后一行代码为return返回句的时候，return也可以省略
        //IInterest interest2 = (a,b) -> a+b;
    }
}

interface IInterest{
    int lambda(int a,int b);
}

//外部类
class Interest implements IInterest{
    @Override
    public int lambda(int a, int b) {
        System.out.println("i like lambda => "+(a+b));
        return a+b;
    }
}
