package Factory.Mediator;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 10 : 31
 * @Description: 财务部
 */
@SuppressWarnings("all")
public class Finacial implements Department {
    private Mediator m;//持有中介者（总经理）的引用

    public Finacial(Mediator m) {
        this.m = m;
        m.register("finacial",this);
    }


    @Override
    public void selfAction() {
        System.out.println("数钱！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，没钱了，钱太多了，该怎么花！");
    }
}
