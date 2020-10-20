package JDBC;

import java.io.IOException;
import java.sql.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 18 : 53
 * @Description: todo
 */
public class JDBCUtil {
    public static Connection getMysqlConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    public static void close(Connection coon){
        try {
            if (coon != null) {
                coon.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(PreparedStatement ps,Connection coon){
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (coon != null) {
                coon.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(ResultSet rs,PreparedStatement ps,Connection coon){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (coon != null) {
                coon.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
