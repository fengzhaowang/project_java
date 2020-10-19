package Factory.Mediator;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 10 : 25
 * @Description: todo
 */
public interface Mediator {
    void register(String dname,Department d);
    void command(String dname);
}
