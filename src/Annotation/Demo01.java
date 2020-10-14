package Annotation;

import jdk.jfr.Percentage;

import javax.xml.crypto.Data;
import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Date;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 12 19 : 45
 * @Description: todo
 */
public class Demo01 extends Object{
    /**
     * @Override 为重写父方法
     * @return
     */
    @Override
    public String toString(){
        return "";
    }

    /**
     * @Deprecated 不建议使用，但可以使用
     */
    @Deprecated
    public static void test01(){
    }

    /**
     * @SuppressWarnings("all") 消除所有警告
     * @SuppressWarnings(value={"unchecked","deprecation"}) 后面可以放多个值得数组
     */
    @SuppressWarnings("all")
    //@SuppressWarnings(value = {"unchecked","deprecation"})
    public static void test02(){
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
    }
}
