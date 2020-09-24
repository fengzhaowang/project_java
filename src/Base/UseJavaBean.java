package Base;

public class UseJavaBean {
    public static void main(String[] args) {
        //创建对象
        JavaBean j = new JavaBean();
        //给对象赋值
        j.setId(20);
        j.setName("张三");
        j.setAge(18);
        j.setSex("男");
        j.setFlag(true);
        //获取并输出对象
        System.out.println("学号："+j.getId()+",姓名："+j.getName()+"，性别："+j.getSex()+"，年龄："+j.getAge());
    }
}
