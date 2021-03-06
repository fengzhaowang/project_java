package Factory.Builder;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 11 : 10
 * @Description: 实现AirShipDirector未实现的方法
 */
public class MakeAirShipDirctor implements AirShipDirector{
    private AirShipBuiler builer;

    //方法重载传参
    public MakeAirShipDirctor(AirShipBuiler builer) {
        this.builer = builer;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine = builer.builderEngine();
        EscapeTower escapeTower = builer.builderEscapeTower();
        OribitalModule oribitalModule = builer.builderOrbitalModelt();

        //装配成飞船对象
        AirShip air = new AirShip();
        air.setEngine(engine);
        air.setEscapeTower(escapeTower);
        air.setOrbitalModule(oribitalModule);

        return air;
    }
}
