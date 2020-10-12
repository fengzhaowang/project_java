package Server.Web3;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 09 - 30 08 : 46
 * @Description:
 * <servlet-mapping>
 *  <servlet-name>login</servlet-name>
 *  <url-pattern>/login</url-pattern>
 *  <url-pattern>/g</url-pattern>
 * </servlet-mapping>
 */
public class Mapping {
    private String name;
    private Set<String> pattens;

    public Mapping() {
        pattens = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPattern() {
        return pattens;
    }

    public void setPattern(Set<String> pattens) {
        this.pattens = pattens;
    }
    public void addPatten(String patten){
        pattens.add(patten);
    }
}
