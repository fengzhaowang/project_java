package Factory.Adapter;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 15 : 26
 * @Description: 适配器(类适配器方式)
 * （相当于usb和ps/2的转接器）
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void handleReq() {
        super.request();
    }
}
