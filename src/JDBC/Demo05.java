package JDBC;

import java.sql.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 10 : 52
 * @Description: 测试事务的基本概念和用法
 */
@SuppressWarnings("all")
public class Demo05 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            coon.setAutoCommit(false);//设置为手动提交

            ps1 = coon.prepareStatement("INSERT INTO cai_info(cainame,money,caiwhere,num,time) values(?,?,?,?,?)");
            ps1.setObject(1,"皮蛋瘦肉粥1");
            ps1.setObject(2,"3.0");
            ps1.setObject(3,"潍坊寿光萝卜集团有限公司");
            ps1.setObject(4,99);
            ps1.setObject(5,new java.sql.Date(System.currentTimeMillis()));
            ps1.execute();
            Thread.sleep(600);

            //此处故意写错，他会报错，之前的语句全部作废，回滚到事务之前的状态
            ps2 = coon.prepareStatement("INSERT INTO cai_info(cainame,money,caiwhere,num,time) values(?,?,?,?,?,?)");
            ps2.setObject(1,"小米稀饭粥");
            ps2.setObject(2,"6.0");
            ps2.setObject(3,"潍坊寿光萝卜集团有限公司");
            ps2.setObject(4,99);
            ps2.setObject(5,new java.sql.Date(System.currentTimeMillis()));
            ps2.execute();

            coon.commit();//提交
        } catch (Exception e) {
            e.printStackTrace();
            try {
                coon.rollback();//如果报错，将进行回滚操作，也就是所有任务全部作废
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                if(ps1 != null){
                    ps1.close();
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