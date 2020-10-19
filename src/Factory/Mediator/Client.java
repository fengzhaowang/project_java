package Factory.Mediator;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 10 : 37
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new President();

        Market market = new Market(m);
        Development devp = new Development(m);
        Finacial f = new Finacial(m);

        market.selfAction();
        market.outAction();
    }
}
