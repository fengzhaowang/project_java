package Javassist;

import javassist.*;

import java.io.IOException;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 13 15 : 19
 * @Description: 测试使用javassist生成一个新的类
 */
public class Demo01 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.xiamaliu.Emp");

        //创建属性
        CtField f1 = CtField.make("private int id;", ctClass);
        CtField f2 = CtField.make("private int name;", ctClass);
        ctClass.addField(f1);
        ctClass.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public void setId(int id){$0.id = id;}", ctClass);
        CtMethod m2 = CtMethod.make("public int getId(){return id;}", ctClass);
        ctClass.addMethod(m1);
        ctClass.addMethod(m2);

        //添加构造器
        /**
         * 第一个参数为构造器的参数类型
         * 自带的参数类型只包括八种数据类型，例如：CtClass.intType
         * 但是没有String类型，只能通过pool.get("java.lang.String")方法调用String类型
         * $0代表this
         */
        //空构造器
        CtConstructor ctConstructor1 = new CtConstructor(new CtClass[]{},ctClass);
        ctClass.addConstructor(ctConstructor1);
        //传参构造器
        CtConstructor ctConstructor2 = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},ctClass);
        ctConstructor2.setBody("{$0.id = id;$0.name = name;}");
        ctClass.addConstructor(ctConstructor2);

        ctClass.writeFile("D:/");
    }
}
