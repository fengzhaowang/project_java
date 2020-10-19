package Factory.Mediator;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 10 : 25
 * @Description: 同事类的接口
 */
public interface Department {
    void selfAction();//做本部门的事情
    void outAction();//向总经理发出申请
}
