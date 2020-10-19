package Factory.Mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 10 : 36
 * @Description: todo
 */
public class President implements Mediator{
    private Map<String,Department> map = new HashMap<>();

    @Override
    public void register(String dname, Department d) {
        map.put(dname,d);
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
