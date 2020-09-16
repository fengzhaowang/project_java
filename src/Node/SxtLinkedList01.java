package Node;

/**
 * 自定义链表
 */
public class SxtLinkedList01 {

    private Node first;
    private Node last;

    private int size;

    //["a"]
    //["a","b"]
    public void add(Object obj){

        //创建node对象，传入obj参数
        Node node = new Node(obj);

        /**
         *  一个节点必须包含上一个节点、下一个节点和元素数据
         *  privious next element
         */


        //第一次创建，first为null，那么新创建的node就是节点，也就是first和last都是node
        if(first == null){
            //全部为空
            node.privious = null;
            node.next = null;

            first = node;
            last = node;
        }else{
            //如果第一个不为空，则node的上一个就是节点的最后一个，所以将last赋值给node的上一个
            node.privious = last;
            //添加一个节点，下一个肯定为null
            node.next = null;

            //首位相接，
            last.next = node;
            last = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp!=null){
            sb.append(temp.element+",");
            temp=temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtLinkedList01 list = new SxtLinkedList01();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list);
    }
}
