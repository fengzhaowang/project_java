package Factory.Facade;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 14 : 51
 * @Description: todo
 */
@SuppressWarnings("all")
public class Client {
    public static void main(String[] args) {
        /**
         * 普通方法调用
         */
        //工商局
        BusinessCircles businessCircles = new HaiDianBusinessCircles();
        businessCircles.checkName();
        //质检局
        QualityInspectionBureau qualityInspectionBureau = new HaiDianQualityInspectionBureau();
        qualityInspectionBureau.orgCodeCertificate();
        //税务局
        Taxation taxation = new HaiDianTaxation();
        taxation.taxCertificate();
        //工商银行
        Bank bank = new ICBC();
        bank.openAccount();

        System.out.println("#############");

        /**
         * 外观模式调用
         */
        new RegisterFacade().register();
    }
}
