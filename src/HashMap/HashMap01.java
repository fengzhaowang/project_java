package HashMap;

/**
 * 自定义一个HashMap
 * 实现了put方法键值对，并解决了键重复的时候覆盖相应的节点
 * 实现get方法
 */
public class HashMap01<K,V> {
    Node[] table;   //位桶数  bucket array
    int size;       //存放的键值对的个数

    public HashMap01(){
        table = new Node[16];
    }

    public static void main(String[] args) {
        HashMap01<Integer,String> m = new HashMap01<>();
        m.put(1,"**");

        m.put(2,"aa");
        m.put(18,"bb");
        m.put(34,"cc");
        m.put(50,"dd");

        m.put(23,"--");

        m.put(5,"小二");
        m.put(21,"小五");
        m.put(37,"小六");
        m.put(53,"小七");

        m.put(28,"//");

        m.put(24,"小二");
        m.put(40,"小五");
        m.put(56,"小六");
        m.put(72,"小七");

        m.put(99,"++");

        System.out.println(m);

        System.out.println(m.get(72));

        System.out.println(m.getSize());

        System.out.println(m.isEmpty());

        //获取相同长度的hash，来测试
        //hash为2  2,18,34,50
        //hash为5  5,21,37,53
        //hash为8  24,40,56,72
//        for (int i = 0;i < 100;i++){
//            System.out.println(i + "---" + myHash(i,16));
//        }
    }

    public V get(K key){
        int hash = myHash(key.hashCode(),table.length);
        V value = null;
        if(table[hash]!=null){
            Node temp = table[hash];
            while (temp!=null){
                if(temp.key.equals(key)){
                    //如果相等，说明找到了相应的键值对，返回相应的value
                    value = (V)temp.value;
                    break;
                }else{
                    temp = temp.next;
                }
            }
        }
        return (V)value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean addK = true;
        for (int i = 0;i < table.length;i++){
            Node temp = table[i];
            while (temp!=null){
                if(temp.next!=null){
                    if(addK){
                        sb.append("{");
                        addK = !addK;
                    }
                    if (temp.hash == temp.next.hash){
                        sb.append(temp.key + ":" + temp.value + ",");
                    }
                }else{
                    sb.append(temp.key + ":" + temp.value + ",");
                    if(!addK){
                        sb.setCharAt(sb.length()-1,'}');
                        sb.append(",");
                        addK = !addK;
                    }
                }
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public void put(K key, V value){
        //定义了新的节点对象
        Node newNode = new Node();
        //获取节点对象要放入的位置
        newNode.hash = myHash(key.hashCode(),table.length);
        //放入的key值
        newNode.key = key;
        //放入的value
        newNode.value = value;
        //只放一个节点，所以下一个节点为null
        newNode.next = null;

        //获取要放入的位置节点
        Node temp = table[newNode.hash];
        //正在遍历的最后一个元素
        Node iterLast = null;
        boolean keyRepeat = false;
        if(temp == null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
            size++;
        }else{
            //此处数组元素不为空，则遍历对应链表
            while (temp!=null){
                //判断key如果重复，则覆盖
                if(temp.key.equals(key)){
                    System.out.println("key重复了！！！");
                    //如果重复，说明hash、key、next都是相等的，只要改变value的值就可以
                    temp.value = value;
                    keyRepeat = true;
                    break;
                }else{
                    //key不重复，则遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }
            if(!keyRepeat){
                //如果没有发生key重复的情况，则添加到链表最后，和上面的else相对应
                iterLast.next = newNode;
                size++;
            }
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0 ? true : false;
    }

    //获取要放入的位置
    public static int myHash(int v,int length){
        //System.out.println("hash in myHash：" + (v&(length-1))); //直接位运算  效率高
        //System.out.println("hash in myHash：" + (v%length));     //取模运算  效率低
        return v&(length-1);
    }
}
