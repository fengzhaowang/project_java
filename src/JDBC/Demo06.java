package JDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 15 : 05
 * @Description: todo
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            for (int i=0;i<1000;i++){
                ps = coon.prepareStatement("INSERT INTO cai_info(cainame,money,caiwhere,num,time,timestamp ) values (?,?,?,?,?,?);");
                ps.setObject(1,"皮蛋瘦肉粥"+i);
                ps.setObject(2,"3.0");
                ps.setObject(3,"潍坊寿光萝卜集团有限公司");
                ps.setObject(4,99);

                int rand = 1000000000+new Random().nextInt(100000000);

                java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
                Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);

                ps.setObject(5,date);
                ps.setObject(6,stamp);
                ps.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps != null){
                    ps.close();
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