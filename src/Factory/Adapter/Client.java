package Factory.Adapter;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 15 : 24
 * @Description: 客户端类（相当于例子中的笔记本，只有USB接口）
 */
public class Client {
    public void test1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        //笔记本
        Client client = new Client();
        //键盘
        Adaptee adaptee = new Adaptee();
        //适配器
        Adapter adapter = new Adapter();

        client.test1(adapter);

        Adapter2 adapter2 = new Adapter2(adaptee);
        client.test1(adapter2);
    }
}
