package Factory.Observer;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 08 : 09
 * @Description: todo
 */
public class ObserverA implements Observer{
    //myState需要跟目标对象的state值保持一致
    private int myState;
    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
