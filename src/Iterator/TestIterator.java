package Iterator;
import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * 测试迭代遍历List、Set、Map
 */
public class TestIterator {
    public static void main(String[] args) {
        //testIteratorList();
        //testIteratorSet();
        testIteratorMap();
    }

    //使用Iterator遍历List
    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        /**
         * 获取迭代器
         * 判断是否有下一个
         * 获取当前元素
         * 打印
         */
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        /**
         * 获取迭代器
         * 判断是否有下一个
         * 获取当前元素
         * 打印
         */
        for (Iterator<String> iter = set.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    public static void testIteratorMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(100,"aaa");
        map.put(200,"bbb");
        map.put(300,"ccc");

        //第一种遍历Map方式（通过entryset获取set集合）
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for(Iterator<Map.Entry<Integer,String>> iter = entrySet.iterator();iter.hasNext();){
            Map.Entry<Integer, String> temp = iter.next();
            System.out.println(temp.getKey() + "--" + temp.getValue());
        }

        System.out.println("********************************");

        //第二种遍历Map方式（通过keyset)
        Set<Integer> keySet = map.keySet();
        for (Iterator<Integer> iter = keySet.iterator();iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key + "---" + map.get(key));
        }

    }
}
