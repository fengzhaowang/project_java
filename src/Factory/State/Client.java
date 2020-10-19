package Factory.State;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 15 : 45
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        HomeContext ctx = new HomeContext();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
        ctx.setState(new CheckInState());
    }
}
