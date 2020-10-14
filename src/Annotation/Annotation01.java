package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 20 : 10
 * @Description: ElementType.METHOD 标志此注解只能放在方法前面
 * RetentionPolicy.RUNTIME 表示可以在class中保留注释信息
 */
//@Target(value = ElementType.METHOD)
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation01 {
    //别处如果使用此注解，此处的属性必须要有默认值，默认值的类型为 defaault 默认值
    //一般默认值为 "" 0 -1  -1代表不存在
    String studentName() default "";
    int age() default 0;
    int id() default -1;//String indexOf("aa");  不存在则返回-1
    String[] schools() default {"山信大","北京航空航天大学"};

}
