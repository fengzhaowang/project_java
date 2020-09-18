package MapAndList;

import java.util.*;

/**
 * 测试表格数据的存储
 */
public class MapAndList {
    public static void main(String[] args) {
        Map<String,Object> row1 = new HashMap<>();
        row1.put("id",1001);
        row1.put("姓名","张三");
        row1.put("薪水",20000);
        row1.put("入职日期","2018.5.5");

        Map<String,Object> row2 = new HashMap<>();
        row2.put("id",1002);
        row2.put("姓名","李四");
        row2.put("薪水",30000);
        row2.put("入职日期","2005.4.4");

        Map<String,Object> row3 = new HashMap<>();
        row3.put("id",1003);
        row3.put("姓名","王五");
        row3.put("薪水",3000);
        row3.put("入职日期","2020.5.4");

        List<Map<String,Object>> table = new ArrayList<>();
        table.add(row1);
        table.add(row2);
        table.add(row3);

        for (Map<String,Object> row : table){
            //获取Map集合的key
            Set<String> keySet = row.keySet();
            //循环遍历key集合
            for (String key : keySet){
                System.out.print(key + ":" + row.get(key) + '\t');
            }
            System.out.println();
        }
    }
}
