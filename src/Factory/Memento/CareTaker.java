package Factory.Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 09 : 33
 * @Description: 负责人类
 * 负责备忘录对象
 */
public class CareTaker {
    private EmpMemento memento;

    //private List<EmpMemento> list = new ArrayList<>();

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
