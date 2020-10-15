package Factory.Builder;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 11 : 14
 * @Description: 建造者模式整个过程
 */
public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new MakeAirShipDirctor(new MakeAirShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine().getName());
        System.out.println(ship.getEscapeTower().getName());
        System.out.println(ship.getOrbitalModule().getName());
        ship.launch();
    }
}
