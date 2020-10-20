package ORM;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 19 : 29
 * @Description: 使用Object[]来封装一条记录
 * 使用List<Object[]>存储多条记录
 */
public class testORM {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object[]> objs = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8","root","12345");
            ps = conn.prepareStatement("SELECT * FROM emp WHERE id = ?");
            ps.setObject(1,1);
            rs = ps.executeQuery();
            while (rs.next()){
                Object[] obj = new Object[6];
                //System.out.println(rs.getString("empname"));
                obj[0] = rs.getObject(1);
                obj[1] = rs.getObject(2);
                obj[2] = rs.getObject(3);
                obj[3] = rs.getObject(4);
                obj[4] = rs.getObject(5);
                obj[5] = rs.getObject(6);
                objs.add(obj);
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
        for(Object[] obj:objs){
            System.out.println(Arrays.toString(obj));
        }
    }
}
