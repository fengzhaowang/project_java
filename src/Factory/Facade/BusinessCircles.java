package Factory.Facade;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 14 : 43
 * @Description: 工商局
 */
public interface BusinessCircles {
    void checkName();//核名
}

class HaiDianBusinessCircles implements BusinessCircles{
    @Override
    public void checkName() {
        System.out.println("检查名字是否有冲突！");
    }
}
