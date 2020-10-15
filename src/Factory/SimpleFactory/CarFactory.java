package Factory.SimpleFactory;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 15 08 : 44
 * @Description: todo
 */
public abstract class CarFactory {
    public static Car creatCar(String type){
        if(type.equals("奥迪")){
            return new Audi();
        }else if(type.equals("比亚迪")){
            return new Byd();
        }else{
            return null;
        }
    }
}
