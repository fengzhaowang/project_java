package ORM;

import java.sql.*;
import java.util.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 19 : 29
 * @Description: 使用Map<String,Object>来封装一条记录
 * 使用Map<String,Map<String,Object>>存储多条记录
 */
public class testORM2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Map<String,Object>> maps = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8","root","12345");
            ps = conn.prepareStatement("SELECT * FROM emp");
            //ps.setObject(1,1);
            rs = ps.executeQuery();
            while (rs.next()){
                Map<String,Object> map = new HashMap<>();
                map.put("id",rs.getObject(1));
                map.put("empname",rs.getObject(2));
                map.put("salary",rs.getObject(3));
                map.put("birthday",rs.getObject(4));
                map.put("age",rs.getObject(5));
                map.put("deptId",rs.getObject(6));
                maps.put(rs.getString(2),map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null) {
                    rs.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        for(String empname:maps.keySet()){
            Map<String,Object> map = maps.get(empname);
            for (String key:map.keySet()){
                System.out.print(map.get(key) + "  ");
            }
            System.out.println();
        }
    }
}
