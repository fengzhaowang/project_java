package Factory.TemplateMethod;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 15 : 15
 * @Description: 模板方法模式
 */
public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        System.out.println("###########");

        //采用匿名内部类
        BankTemplateMethod btm2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存款！！！");
            }
        };
        btm2.process();
    }
}
class DrawMoney extends BankTemplateMethod{
    @Override
    public void transact() {
        System.out.println("我要取款！！！");
    }
}
