package Factory.Strategy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 14 : 45
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        Strategy s1 = new OldCustomerManyStrategy();
        Context ctx = new Context(s1);
        ctx.pringPrice(998);
    }
}
