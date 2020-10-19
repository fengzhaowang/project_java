package Factory.Mediator;

import java.lang.annotation.Annotation;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 17 10 : 28
 * @Description: 开发部
 */
@SuppressWarnings("all")
public class Development implements Department {
    private Mediator m;//持有中介者（总经理）的引用

    public Development(Mediator m) {
        this.m = m;
        m.register("development",this);
    }


    @Override
    public void selfAction() {
        System.out.println("专心科研，开发项目！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，没钱了，需要资金支持！");
    }
}
