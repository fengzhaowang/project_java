package Javassist;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 15 : 57
 * @Description: 测试javassist的API
 */
@SuppressWarnings("all")
public class Demo02 {

    /**
     * 处理类的基本用法
     * @throws Exception
     */
    @SuppressWarnings("all")
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("Javassist.Emp");

        byte[] bytes = ctClass.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(ctClass.getName());//获取类名
        System.out.println(ctClass.getSimpleName());//获取简要类名
        System.out.println(ctClass.getSuperclass());//获取父类
        System.out.println(ctClass.getInterfaces());//获取接口数组
    }

    /**
     * 测试产生新的方法
     */
    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("Javassist.Emp");

        //CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}",ctClass);

        CtMethod m = new CtMethod(CtClass.intType,"add",new CtClass[]{CtClass.intType,CtClass.intType},ctClass);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"com.xiamaliu\");return $1+$2;}");

        ctClass.addMethod(m);

        //通过反射调用新的方法
        Class<?> clazz = ctClass.toClass();
        Object obj = clazz.newInstance();//通过调用Emp无参构造器。创建新的Emp对象
        Method method = clazz.getDeclaredMethod("add",int.class,int.class);
        Object result = method.invoke(obj,200,300);
        System.out.println(result);
    }


    /**
     * 修改已有的方法信息，修改方法体的内容
     * @throws Exception
     */
    public static void test03() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("Javassist.Emp");

        CtMethod cm = ctClass.getDeclaredMethod("sayHello", new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");//方法之前添加语句
        cm.insertAt(20,"System.out.println(\"中间!!!\");");//指定行数添加语句
        cm.insertAfter("System.out.println(\"end!!!\");");//方法之后添加语句

        //通过反射调用新生成的方法
        Class clazz = ctClass.toClass();
        Object obj = clazz.newInstance();//通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("sayHello",int.class);
        Object result = method.invoke(obj,300);
        System.out.println(result);
    }
    public static void main(String[] args) throws Exception {
        test03();
    }
}
