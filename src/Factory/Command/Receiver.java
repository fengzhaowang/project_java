package Factory.Command;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 11 : 02
 * @Description: 真正的命令的执行者
 */
public class Receiver {
    public void action() {
        System.out.println("Receiver.action()");
    }
}
