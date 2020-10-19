package Factory.State;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 15 : 41
 * @Description: 空闲状态
 */
public class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("房间空闲，没人住！！！");
    }
}
