package Node;

/**
 * 自定义链表
 * 增加get方法
 */
public class SxtLinkedList02 {

    private Node first;
    private Node last;

    private int size;

    public Object get(int index){
        if(index<0||index>size-1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
        Node temp = getNode(index);

        return temp!=null?temp.element:null;
    }

    public Node getNode(int index){
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

        size++;
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
        SxtLinkedList02 list = new SxtLinkedList02();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list);
    }
}
