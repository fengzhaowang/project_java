package Factory.State;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 15 : 41
 * @Description: 已入住
 */
public class CheckInState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住，请勿打扰！！！");
    }
}
