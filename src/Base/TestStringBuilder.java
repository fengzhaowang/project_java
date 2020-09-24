package Base;

public class TestStringBuilder {
    public static void main(String[] args) {
        String str;

        /**
         * 他两个的指向地址是一样的，所以说StringBuilder是可变字符序列，里面的内容是可以随意修改的
         */

        //StringBuilder线程不安全，但效率高（*）；StringBuffer线程安全，但效率低
        StringBuilder sb = new StringBuilder("abcdefg");

        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

        sb.setCharAt(2,'M');

        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);
    }
}
