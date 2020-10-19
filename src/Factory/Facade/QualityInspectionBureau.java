package Factory.Facade;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 14 : 46
 * @Description: 质检局
 */
public interface QualityInspectionBureau {
    void orgCodeCertificate();//办理组织机构代码证
}
class HaiDianQualityInspectionBureau implements QualityInspectionBureau{
    @Override
    public void orgCodeCertificate() {
        System.out.println("在海淀区质监局办理组织机构代码证！");
    }
}
