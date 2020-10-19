package Factory.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 07 : 59
 * @Description: todo
 */
public class Subject {
    protected List<Observer> list = new ArrayList<>();

    public void registerObserver(Observer obs){
        list.add(obs);
    }

    public void removeObserver(Observer obs){
        list.remove(obs);
    }
    //通知所有的观察者更新状态
    public void notifyAllObservers(){
        for (Observer obs : list){
            obs.update(this);
        }
    }
}
