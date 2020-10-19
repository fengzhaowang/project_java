package Factory.Facade;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 14 : 45
 * @Description: 银行
 */
public interface Bank {
    void openAccount();//开户
}
//中国工商银行
class ICBC implements Bank{
    @Override
    public void openAccount() {
        System.out.println("在中国工商银行开户！");
    }
}
