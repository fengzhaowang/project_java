package JDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 15 : 05
 * @Description: 测试时间处理（java.sql.Data,Time,Timestamp)，取出指定时间段的数据
 */
public class Demo07 {
    /**
     * 将字符串代表的日期转为long数字（格式：yyyy-MM-dd hh:mm:ss）
     * @param time
     * @return
     */
    public static long strDate(String time){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");

            ps = coon.prepareStatement("SELECT * FROM cai_info WHERE time > ? AND time < ?");

            //java.sql.Date start = new java.sql.Date(strDate("2020-10-5 10:23:45"));
            //java.sql.Date end = new java.sql.Date(strDate("2020-10-8 10:23:45"));
            java.sql.Timestamp start = new java.sql.Timestamp(strDate("2020-10-5 10:23:45"));
            java.sql.Timestamp end = new java.sql.Timestamp(strDate("2020-10-8 10:23:45"));

            ps.setObject(1,start);
            ps.setObject(2,end);

            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("菜id:"+rs.getString("id")+",菜名："+rs.getString("cainame")+",价格："+rs.getString("money")+
                        ",生产地址"+rs.getString("caiwhere")+",剩余个数："+rs.getInt("num")+",日期："+rs.getDate("time")+",具体日期"+rs.getTimestamp("timestamp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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