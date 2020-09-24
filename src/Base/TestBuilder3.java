package Base;

/**
 * 不可变和可变字符序列使用陷阱
 */
public class TestBuilder3 {
    public static void main(String[] args) {
        /**使用String进行字符串的拼接*/
        String str = null;
        //每次进行一次循环，都会重新生成一个对象，
        long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time1 = System.currentTimeMillis();//获取系统的当前时间
        for (int i = 0;i < 5000;i++){
            str += i;
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用内存 : " + (num1 - num2));
        System.out.println("String占用时间 : " + (time2 - time1));

        /**使用StringBuilder进行字符串的拼接*/
        StringBuilder str2 = new StringBuilder();
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        for (int i = 0;i < 5000;i++){
            str2.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilder占用内存 : " + (num3 - num4));
        System.out.println("StringBuilder占用时间 : " + (time4 - time3));
    }
}
