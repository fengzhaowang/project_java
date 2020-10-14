package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 20 : 50
 * @Description: 使用反射读取注解的信息，模拟处理注解信息的流程
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("Annotation.Student");
            //获取类的所有有效注解
            Annotation[] annotation = clazz.getAnnotations();
            for (Annotation a:annotation){
                System.out.println(a);
            }
            //获取类的指定的注解
            Table table = (Table)clazz.getAnnotation(Table.class);
            System.out.println(table.value());
            //获得类的属性的注解
            @SuppressWarnings("all")
            /**
             * @Fields(columnName = "id",type = "varchar",length = 10)
             * private String studentName;
             */
            Field studentName = clazz.getDeclaredField("studentName");
            Fields f = studentName.getAnnotation(Fields.class);
            System.out.println(f.columnName()+"--"+f.type()+"--"+f.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
