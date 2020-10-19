package Factory.State;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 15 : 41
 * @Description: 已预订
 */
public class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已预订，别人不能预订！！！");
    }
}
