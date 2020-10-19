package JDBC;

import java.sql.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 08 : 48
 * @Description: 测试preparedStatement
 */
@SuppressWarnings("all")
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            String sql = "INSERT INTO cai_info(cainame,money,caiwhere,num,time) values(?,?,?,?,?)";
            PreparedStatement ps = coon.prepareStatement(sql);
            ps.setString(1,"皮蛋瘦肉粥");
            ps.setString(2,"3.0");
            ps.setString(3,"潍坊寿光萝卜集团有限公司");
            //ps.setInt(4,99);

            //还可以使用
            ps.setObject(5,new java.sql.Date(System.currentTimeMillis()));

            ps.execute();//执行插入
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}