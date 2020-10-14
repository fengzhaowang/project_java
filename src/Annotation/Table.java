package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 20 : 39
 * @Description: 类的注解
 */
@Target(value = {ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
