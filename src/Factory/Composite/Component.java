package Factory.Composite;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 09 : 18
 * @Description: 抽象组件
 */
public interface Component {
    void operation();
}
//叶子组件
interface Leaf extends Component{
}
//容器组件
interface Composite extends Component{
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}