package Node;

public class Node {
    Node privious;      //上一个节点
    Node next;          //下一个节点
    Object element;;    //元素数据

    //创建构造器
    public Node(Node privious, Node next, Object element) {
        this.privious = privious;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
