package Server.WebOver.Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 09 09 : 13
 * @Description: todo
 */
public class WebContext {
    private List<Entity> etities = null;
    private List<Mapping> mappings = null;
    /**
     * key -> servlet-name  value -> servlet-class
     */
    Map<String,String> entityMap = new HashMap<>();
    /**
     * key -> url-pattern  value -> servlet-name
     */
    Map<String,String> mappingMap = new HashMap<>();
    public WebContext(List<Entity> etities, List<Mapping> mappings) {
        this.etities = etities;
        this.mappings = mappings;

        //将entity的List转换成对应的map
        for(Entity entity:etities){
            entityMap.put(entity.getName(),entity.getClz());
        }
        //将mapping的List转换成对应的map
        for(Mapping mapping:mappings){
            for(String s:mapping.getPattern()){
                mappingMap.put(s,mapping.getName());
            }
        }
    }

    /**
     * 通过URL的路径找到了对应的class
     * @param pattern 传入的需要找class的URL
     * @return class
     */
    public String getClz(String pattern){
        String name = mappingMap.get(pattern);
        return entityMap.get(name);
    }
}
