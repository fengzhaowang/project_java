package Factory.Builder;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 11 : 01
 * @Description: build接口，构建子组件
 */
public interface AirShipBuiler {
    Engine builderEngine();
    OribitalModule builderOrbitalModelt();
    EscapeTower builderEscapeTower();
}
