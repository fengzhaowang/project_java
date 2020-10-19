package Factory.Facade;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 14 : 55
 * @Description: 办理注册公司的门面对象（外观模式）
 */
public class RegisterFacade {
    public void register() {
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
    }
}
