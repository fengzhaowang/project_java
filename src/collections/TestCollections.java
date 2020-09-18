package collections;

import com.sun.tools.javac.Main;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collection辅助类的使用
 * Collection是接口 Collections是工具类
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            list.add("sun@"+i);
        }
        System.out.println(list);

        Collections.shuffle(list);//随机排列list中的元素
        System.out.println(list);

        Collections.reverse(list);//逆向排列
        System.out.println(list);

        Collections.sort(list);//按照递增的方法排序，自定义类的使用：Comparable接口
        System.out.println(list);

        System.out.println(Collections.binarySearch(list,"sun@5"));
    }

}
