package Factory.Proxy.StaticProxy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 16 : 52
 * @Description: todo
 */
public class RealStar implements Star{
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void singContract() {
        System.out.println("RealStar.singContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing(周杰伦本人)");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}
