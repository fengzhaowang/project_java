package Factory.Builder;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 11 : 05
 * @Description: 实现AirShipBuiler未实现的方法
 */
@SuppressWarnings("all")
public class MakeAirShipBuilder implements AirShipBuiler{
    //StringBuilder，以后学习XML解析中，JDOM库中的类，DomBuilder，SaxBuilder
    @Override
    public Engine builderEngine() {
        System.out.println("构建发动机！");
        return new Engine("发动机！");
    }

    @Override
    public OribitalModule builderOrbitalModelt() {
        System.out.println("构建轨道舱！");
        return new OribitalModule("轨道舱！");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔！");
        return new EscapeTower("逃逸塔！");
    }
}
