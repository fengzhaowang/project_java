package Factory.State;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 15 : 38
 * @Description: 房间对象
 */
@SuppressWarnings("all")
public class HomeContext {
    //如果是银行系统，这个Context类就是账号，根据金额不同，切换不同状态

    private State state;

    public void setState(State s){
        System.out.println("修改状态！");
        state = s;
        state.handle();
    }
}
