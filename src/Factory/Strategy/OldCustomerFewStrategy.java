package Factory.Strategy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 14 : 34
 * @Description: 老客户小批量
 */
public class OldCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrince) {
        System.out.println("打八五折！");
        return standardPrince*0.85;
    }
}
