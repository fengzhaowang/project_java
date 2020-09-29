package Chat;

import java.io.Closeable;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 29 09 : 24
 * @Description: todo
 */
public class Utils {
    public static void close(Closeable... targets){
        for(Closeable target:targets){
            try {
                if(target != null){
                    target.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
