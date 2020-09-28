package Others;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 24 15 : 51
 * @Description: volatile用于保证数据的同步，也就是可见性
 */
public class VolatileTest {
    private volatile static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0){//此处不要写代码

            }
        });
        //此处理论上是等两秒之后num变为1，while循环停止，可是实际没有停止，这是因为电脑没有时间同步num，导致num还是为0
        //解决办法：给变量添加volatile，只要改变num值，主存的内部机制就会直接同步num
        Thread.sleep(2000);
        num = 1;

    }
}
