package Factory.Command;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 11 : 03
 * @Description: todo
 */
public interface Command {
    /**
     * 这个方法是一个返回结果为空的方法
     * 实际项目中，可以根据需求设计多个不同的方法
     */
    void execute();
}
@SuppressWarnings("all")
class ConcreteCommand implements Command{

    private Receiver receiver;//命令的真正的执行者

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //命令真正执行前或后，执行相关的处理！
        receiver.action();
    }
}