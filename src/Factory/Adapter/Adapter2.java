package Factory.Adapter;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 15 : 26
 * @Description: 适配器(对象适配器方式，使用了组合的方式)
 * （相当于usb和ps/2的转接器）
 */
public class Adapter2 implements Target{
    private Adaptee adaptee;

    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adapter2(Adaptee adaptee) {
        super();
        this.adaptee = adaptee;
    }
}
