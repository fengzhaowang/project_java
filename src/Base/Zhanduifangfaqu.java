package Base;

public class Zhanduifangfaqu {
    int id;
    String sname;
    int age;

    Computer comp;

    void study(){
        System.out.println("我在认真学习！！，使用电脑"+comp.brand);
    }

    void play() {
        System.out.println("我在玩游戏！王者农药！");
    }


    public static void main(String[] args) {
        Zhanduifangfaqu data = new Zhanduifangfaqu();
        System.out.println(data);
        data.id=1001;
        data.sname="高淇";
        data.age=18;

        Computer c1 = new Computer();
        c1.brand = "联想";

        data.comp = c1;

        data.play();
        data.study();
    }
}
class Computer{
    String brand;
}
