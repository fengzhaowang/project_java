package Factory.Adapter;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 15 : 22
 * @Description: 被适配的类（相当于例子中的，PS/2键盘）
 */
public class Adaptee {
    public void request(){
        System.out.println("可以完成客户请求的需要的内容！");
    }
}
