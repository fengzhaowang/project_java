package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 10 : 52
 * @Description: 测试使用批处理的基本用法
 */
@SuppressWarnings("all")
public class Demo04 {
    public static void main(String[] args) {
        Connection coon = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            coon.setAutoCommit(false);//设置为手动提交
            long start = System.currentTimeMillis();
            statement = coon.createStatement();
            for (int i=0;i<20000;i++){
                statement.addBatch("INSERT INTO cai_info(cainame,money,caiwhere,num,time) values('皮蛋瘦肉粥"+i+"号','3.0','潍坊寿光萝卜集团有限公司',99,now())");
            }
            statement.executeBatch();//执行批处理
            coon.commit();//提交事务
            long end = System.currentTimeMillis();
            System.out.println("总耗时："+(end-start));
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