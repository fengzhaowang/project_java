package Factory.Observer2;

import java.util.Observable;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 08 : 20
 * @Description: todo
 */
public class ConcreteSubject extends Observable {
    private int state;

    public void set(int s){
        //目标对象的状态发生了改变
        state = s;
        //表示目标对象已经做了更改
        setChanged();
        //通知所有的观察者
        notifyObservers(state);
    }
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
