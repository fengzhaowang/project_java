package collection;

public class TestGeneric {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<>();
        mc.set("天天学习",0);
        String s = mc.get(0);

        MyCollection<Integer> mc1 = new MyCollection<>();
        mc1.set(1314,0);
        Integer s1 = mc1.get(0);

        System.out.println(s);
        System.out.println(s1);

    }


}
class MyCollection<E>{
    Object[] objs = new Object[5];

    public void set(E e,int index){
        objs[index]  = e;
    }

    public E get(int index){
        return (E)objs[index];
    }
}
