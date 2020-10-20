package JDBC;

import java.io.*;
import java.sql.*;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 15 : 05
 * @Description: 测试BLOB  文本大对象的使用
 */
@SuppressWarnings("all")
public class Demo09 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            /*
            ps = coon.prepareStatement("INSERT INTO cai_info(id,cainame,money,caiwhere,num,time,timestamp,image ) values(?,?,?,?,?,?,?,?)");
            ps.setObject(1,2);
            ps.setObject(2,"皮蛋瘦肉粥");
            ps.setObject(3,"3.0");
            ps.setObject(4,"潍坊寿光萝卜集团有限公司");
            ps.setObject(5,99);
            ps.setObject(6,new java.sql.Date(System.currentTimeMillis()));
            ps.setObject(7,new java.sql.Date(System.currentTimeMillis()));
            //将文件转换为二进制存入数据库中
            ps.setBlob(8,new FileInputStream("f:/a.jpg"));
            ps.execute();*/

            ps = coon.prepareStatement("SELECT * FROM cai_info WHERE id = ?");
            ps.setObject(1, 2);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blob cl = rs.getBlob("image");
                os = new FileOutputStream("d:/a.png");
                is = cl.getBinaryStream();
                int temp = 0;
                while ((temp = is.read()) != -1) {
                    os.write(temp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
}