package Factory.ChainOfResp;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 09 : 12
 * @Description: 责任链（职责链）模式
 */
public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new GeneralManager("王五");

        //组织责任链对象的关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        //开始请假操作
        LeaveRequest req1 = new LeaveRequest("TOM",20,"回老家探亲");
        a.handleRequest(req1);
    }
}
