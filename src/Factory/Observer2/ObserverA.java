package Factory.Observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 08 : 23
 * @Description: todo
 */
public class ObserverA implements Observer {
    private int myState;
    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
