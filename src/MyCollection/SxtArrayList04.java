package MyCollection;

/**
 * 增加set和get方法
 * 增加数组边界的检查
 * @param <E>
 */
public class SxtArrayList04<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public SxtArrayList04(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    public SxtArrayList04(int capacty){
        if(capacty < 0){
            throw new RuntimeException("容器的容量不能为负数");
        }else if(capacty == 0){
            elementData = new Object[DEFALT_CAPACITY];
        }else{
            elementData = new Object[capacty];
        }

    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }
    public void set(E element,int index){
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index){
        //索引合法判断[0,size)  10  0-9
        if(index<0||index>size-1){
            throw new RuntimeException("索引不合法："+index);
        }
    }

    public void remove(E element){
        //element 将它所有元素挨个比较
        for(int i = 0;i < size;i++){
            if (element.equals(get(i))){//容器中所有的比较都是使用equals，而不是==
                //将该元素从此处移除

            }
        }
    }

    public void remove(int index){
        //使用数组的拷贝进行删除其中一个元素
        int numMoved = (elementData.length-index)-1;
        System.arraycopy(elementData,index-1,elementData,index,numMoved);
        elementData[--size] = null;
    }

    //数组的扩容操作
    public void add(E element){
        //什么时候扩容
        if (size == elementData.length){
            //扩容操作 
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData=newArray;
        }
        elementData[size++] = element;
    }


    

    //获取数组字符串
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0;i < size;i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtArrayList04 s1 = new SxtArrayList04(20);

        for (int i = 0;i < 40;i++){
            s1.add("aa"+i);
        }

        s1.get(40);
        System.out.println(s1);
    }
}
