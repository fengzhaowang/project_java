package Base;

public class TestBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (var i = 0;i < 26;i++){
            char temp = (char) ('a'+i);
            str.append(temp);
        }
        System.out.println(str);
        str.reverse();//倒叙
        System.out.println(str);
        str.setCharAt(3,'高');
        System.out.println(str);
        str.insert(0,'我').insert(5,'爱').insert(10,'你');//链式调用，核心就是该方法调用的return this，把自己返回
        System.out.println(str);

        str.delete(20,23);//左闭右开，[20，23)，该方法也可以链式调用
        System.out.println(str);


    }
}
