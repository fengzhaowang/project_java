package Base;

/**
 * 测试包装类
 */
public class TestWrappedClass {
    public static void main(String[] args) {
        //基本数据类型转换成包装类对象
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(30);

        //包装类对象转换成基本数据类型
        int c = b.intValue();
        double d = b.doubleValue();

        //把字符串转换为包装类对象
        Integer e = new Integer("6666777");
        Integer f = Integer.parseInt("88888");

        //把包装类对象转换为字符串
        String g = f.toString();

        //常见的变量
        System.out.println("int类型的最大值："+Integer.MAX_VALUE);
        System.out.println("int类型的最小值："+Integer.MIN_VALUE);

    }
}
