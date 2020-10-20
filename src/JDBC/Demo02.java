package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 08 : 48
 * @Description: 测试Statement接口的用法，执行SQL语句，以及SQL注入问题
 */
@SuppressWarnings("all")
public class Demo02 {
    public static void main(String[] args) {
        Connection coon = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            statement = coon.createStatement();
            String sql = "SELECT * FROM cai_info";
            boolean execute = statement.execute(sql);
            System.out.println(execute);
            if(execute){
                resultSet = statement.executeQuery(sql);
                List<Cai> list = new ArrayList<>();
                while (resultSet.next()){
                    Cai cai = new Cai();
                    cai.setId(resultSet.getInt("id"));
                    cai.setCainame(resultSet.getString("cainame"));
                    cai.setCaiwhere(resultSet.getString("caiwhere"));
                    cai.setMoney(resultSet.getString("money"));
                    cai.setNum(resultSet.getInt("num"));
                    list.add(cai);
                }
                for (Cai c:list){
                    System.out.println("菜id:"+c.getId()+",菜名："+c.getCainame()+",价格："+c.getMoney()+",生产地址"+c.getCaiwhere()+",剩余个数："+c.getNum());
                }
            }

            //危险测试SQL注入,容易被更改数据库
            //String id = "5 or 1=1 ";
            //sql = "delete from cai_info where id = "+id;
            //statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(coon != null) {
                    coon.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
class Cai{
    private int id;
    private String cainame;
    private String money;
    private String caiwhere;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCainame() {
        return cainame;
    }

    public void setCainame(String cainame) {
        this.cainame = cainame;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCaiwhere() {
        return caiwhere;
    }

    public void setCaiwhere(String caiwhere) {
        this.caiwhere = caiwhere;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}