package Factory.SimpleFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 08 : 31
 * @Description: todo
 */
public class Audi implements Car{
    @Override
    public void run() {
        System.out.println("奥迪在跑！！");
    }
}
