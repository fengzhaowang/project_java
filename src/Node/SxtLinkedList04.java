package Node;

/**
 * 自定义链表
 * 增加get方法
 * 增加remove方法
 */
public class SxtLinkedList04<E> {

    private Node first;
    private Node last;
    private int size;

    public static void main(String[] args) {
        SxtLinkedList04<String> list = new SxtLinkedList04<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        list.add(3,"老高");
        System.out.println(list);
    }

    //["a"]
    //["a","b"]
    public void add(E element){
        //创建node对象，传入obj参数
        Node node = new Node(element);
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

        size++;
    }

    public void add(int index,E element){
        checkRange(index);
        //创建新节点
        Node newNode = new Node(element);
        //获取指定下标的节点
        Node temp = getNode(index);
        if(temp!=null){
            if(index == 0){
                first = newNode;
                first.next = temp;
                temp.privious = first;
            }else if(index == (size-1)){
                last = temp;
                last.next = newNode;
                newNode.privious = last;
            }else{
                //获取指定下标（也就是插入的下一个节点）节点的前一个节点
                Node up = temp.privious;
                //将newNode节点链接到前一个节点
                up.next = newNode;
                newNode.privious = up;
                //将原指定下标连接到新节点
                newNode.next = temp;
                temp.privious = newNode;
            }
            size++;
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

    public E get(int index){
        checkRange(index);
        Node temp = getNode(index);
        return temp != null ? (E)temp.element : null;
    }

    public Node getNode(int index){
        checkRange(index);
        Node temp = null;
        //从前往后找
        if(index<=(size>>1)){   //size>>1相当于除以2
            temp = first;
            for(int i = 0;i < index;i++){
                temp = temp.next;
            }
        }else{
            //从后往前找
            temp = last;
            for(int i = size-1;i < index;i--){
                temp = temp.privious;
            }
        }
        return temp;
    }

    public void remove(int index){
        checkRange(index);
        Node temp = getNode(index);
        /**
         *  第一步：把temp的前一个节点给up  后一个节点给down
         *  第二步：将后一个链接到前一个  将前一个链接到后一个
         *  第三部：如果要删除的元素为第一个或者为最后一个的时候，直接将首位相接
         */
        if(temp!=null){
            Node up = temp.privious;
            Node down = temp.next;
            if(up != null){
                up.next = down;
            }
            if(down != null){
                down.privious = up;
            }
            //被删除的元素是第一个元素时
            if(index == 0){
                first = down;
            }
            //被删除的元素时最后一个元素时
            if(index == size-1){
                last = up;
            }
            size--;
        }
    }

    private void checkRange(int index){
        if(index<0||index>size-1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
    }
}
