package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        test01();
    }

    public static void test01(){
        Collection<String> c = new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("你好啊？");
        c.add("你好吗？");
        c.add("我挺好的！");

        Object[] objects = c.toArray();
        System.out.println(objects);

        System.out.println(c);

        c.remove("你好吗？");
        System.out.println(c);

        c.clear();
        System.out.println(c);
    }

    public static void test02() {
        Collection<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        Collection<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:"+list01);
        System.out.println("list02:"+list02);

        //list01.addAll(list02);//将list02所有的元素全部添加到list01中去
        //list01.removeAll(list02);//删除两个数组相同元素的部分
        list01.retainAll(list02);//取两个数组中相同的部分
        System.out.println(list01);

        System.out.println(list01.containsAll(list02));//判断list01中是否包含list02中所有的元素
    }

    public static void test03(){
        List<String> list02 = new ArrayList<>();
        list02.add("A");
        list02.add("B");
        list02.add("C");
        list02.add("D");

        System.out.println(list02);

        list02.add(2,"O");
        System.out.println(list02);

        list02.remove(2);
        System.out.println(list02);

        list02.set(1,"P");
        System.out.println(list02);

        System.out.println(list02.get(2));

        list02.add("D");
        list02.add("C");
        list02.add("B");
        list02.add("A");
        System.out.println(list02);

        System.out.println(list02.indexOf("A"));

        System.out.println(list02.lastIndexOf("A"));
    }
}
