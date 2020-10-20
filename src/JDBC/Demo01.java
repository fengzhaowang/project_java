package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 08 : 29
 * @Description: 测试数据库连接
 */
public class Demo01 {
    public static void main(String[] args) {
        Connection coon = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            long start = System.currentTimeMillis();
            //建立连接(连接对象内部其实包含了Socket对象，是一个远程连接，比较耗时，这是Cinnection对象管理的一个要点)
            //真正开发中，为了提高效率，都会使用连接池来管理连接对象
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            long end = System.currentTimeMillis();
            System.out.println(coon);
            System.out.println("总耗时："+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
