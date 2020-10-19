package Lambda;

/**
 * 简化多线程
 */
@SuppressWarnings("all")
public class LambdaTest04 {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("一边学习lambda");
        }).start();
        new Thread(() -> {
            System.out.println("一边崩溃中");
        }).start();
    }
}
