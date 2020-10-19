package Factory.Strategy;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 14 : 36
 * @Description: 普通客户大批量
 */
public class NewCustomerManyStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrince) {
        System.out.println("打九折！");
        return standardPrince*0.9;
    }
}
