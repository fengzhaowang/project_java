package com.xiamaliu;

/**
 * integer自动装箱与拆箱
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 10; //自动装箱：相当于Integer a = Integer.valueOf(10);
        int b = a; //自动拆箱：相当于int b = a.intValue();

        Integer c = null;
        //int d = c; //此处报错：原因是进行了自动拆箱，拆箱原Integer不能为null，所以可以添加一个判断
        if(c != null){
            int d = c;
        }
        /**
         * 缓存[-128，127]之间的数字，实际上是系统初始的时候，创建了[-128，127]之间的一个缓存数组
         * 当我们调用valueOf()的时候，首先检查是否在[-128，127]之间，如果在这个范围内，则直接从缓存数组中拿出已经建好的对象
         * 如果不在这范围内，则创建新的包装类对象
         * 最直接的原因就是为了防止由于小的数据多次创建对象，影响反应速度
         */
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = -128;
        System.out.println(in1 == in2);//此处为true,因为他们是同一个对象，也就是同一数组，在valueOf的源码中的IntegerCache中可查看
        System.out.println(in1.equals(in2));//此处为true，因为他俩的值是相同的

        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);//此处为false，因为他俩不是同一对象
        System.out.println(in3.equals(in4));//此处为true，因为他俩的值是相同的
    }
}
