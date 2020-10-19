package Factory.Observer;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 08 : 05
 * @Description: todo
 */
public class ConcreteSubject extends Subject{
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //主题对象（目标对象）值发生了变化，请通知所有的观察者
        this.notifyAllObservers();
    }
}
