package Annotation;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 20 : 11
 * @Description: @Annotation01 已经声明既可以加在方法前面也可以加在类前面
 */
@Annotation01()
public class Demo02 {
    @Annotation01(age = 19,studentName = "天天向上",id = 1001,
            schools = {"北京大学","清华大学"})
    public void test01(){

    }

    /**
     * 只有一种参数的时候可以省略属性名
     */
    @Annotation02(value = "aaa")
    //@Annotation02("aaa")
    public void test02(){

    }
}
