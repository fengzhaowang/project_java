package Factory.Strategy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 14 : 34
 * @Description: 普通客户小批量
 */
public class NewCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrince) {
        System.out.println("不打折，原价！");
        return standardPrince;
    }
}
