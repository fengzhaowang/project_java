package Factory.Bridge;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 08 : 45
 * @Description: 销售的品牌
 */
public interface Brand {
    void sale();
}
class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}
class Dell implements Brand{
    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}