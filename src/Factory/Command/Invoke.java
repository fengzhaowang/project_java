package Factory.Command;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 11 : 12
 * @Description: 调用者/发起者
 */
@SuppressWarnings("all")
public class Invoke {
    private Command command;//也可以通过容器List<Command>容纳很多命令对象，进行批处理，数据库底层的事务管理就是类似的结构！

    public Invoke(Command command){
        super();
        this.command = command;
    }

    //业务方法，用于调用命令类的方法
    public void call(){
        command.execute();
    }
}
