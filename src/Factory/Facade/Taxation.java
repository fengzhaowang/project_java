package Factory.Facade;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 14 : 43
 * @Description: 税务局
 */
public interface Taxation {
    void taxCertificate();//办理税务登记证
}
class HaiDianTaxation implements Taxation{
    @Override
    public void taxCertificate() {
        System.out.println("在海淀税务局办理税务登记证！");
    }
}
