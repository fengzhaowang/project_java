package Factory.FlyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 16 15 : 15
 * @Description: 享元工厂类
 */
public class ChessFlyWeightFactory {
    //享元池
    private static Map<String,ChessFlyWeight> map = new HashMap<>();
    public static ChessFlyWeight getChess(String color){
        if(map.get(color) != null){
            return map.get(color);
        }else{
            ChessFlyWeight flyWeight = new ConcreteChess(color);
            map.put(color,flyWeight);
            return flyWeight;
        }
    }
}
