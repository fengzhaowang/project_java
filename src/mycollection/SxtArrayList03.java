package mycollection;

/**
 * 添加数组扩容
 * @param <E>
 */
public class SxtArrayList03<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFALT_CAPACITY = 10;

    public SxtArrayList03(){
        elementData = new Object[DEFALT_CAPACITY];
    }

    public SxtArrayList03(int capacty){
        elementData = new Object[capacty];
    }

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
        SxtArrayList03 s1 = new SxtArrayList03(20);

        for (int i = 0;i < 40;i++){
            s1.add("aa"+i);
        }

        System.out.println(s1);
    }
}
