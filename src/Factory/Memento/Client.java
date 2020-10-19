package Factory.Memento;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 18 09 : 35
 * @Description: todo
 */
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("小明",18,900);
        System.out.println("第一次打印对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());

        //备忘第一次
        taker.setMemento(emp.memento());

        emp.setAge(38);
        emp.setEname("小红");
        emp.setSalary(9000);
        System.out.println("第二次打印对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());

        //恢复到备忘录对象保存的状态
        emp.recovery(taker.getMemento());
        System.out.println("第三次打印对象："+emp.getEname()+"---"+emp.getAge()+"---"+emp.getSalary());
    }
}
