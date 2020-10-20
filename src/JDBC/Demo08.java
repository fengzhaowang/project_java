package JDBC;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @BelongsProject: Practice_Java
 * @Author: loveT
 * @Date: Created in 2020 - 10 - 19 15 : 05
 * @Description: 测试CLOB  文本大对象的使用
 * 包含：将字符串、文件内容插入数据库中的CLOB字段，将CLOB字段取出来的操作。
 */
@SuppressWarnings("all")
public class Demo08 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reader r = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/cai?serverTimezone=UTC&useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=utf-8",
                    "root", "12345");
            /*
            ps = coon.prepareStatement("INSERT INTO cai_info(id,cainame,money,caiwhere,num,time,timestamp ) values(?,?,?,?,?,?,?)");
            ps.setObject(1,1);

            //将文件中的内容转为字符流进行插入数据库操作
            //ps.setClob(2,new FileReader(new File("d:/a.txt")));
            //将程序中的字符串输入到数据库的CLOB字段中
            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("天天向上菜品".getBytes()))));

            ps.setObject(3,"3.0");
            ps.setObject(4,"潍坊寿光萝卜集团有限公司");
            ps.setObject(5,99);
            ps.setObject(6,new java.sql.Date(System.currentTimeMillis()));
            ps.setObject(7,new java.sql.Date(System.currentTimeMillis()));
            ps.execute();*/

            ps = coon.prepareStatement("SELECT * FROM cai_info WHERE id = ?");
            ps.setObject(1, 21012);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clob cl = rs.getClob("cainame");
                r = cl.getCharacterStream();
                int temp = 0;
                while ((temp = r.read()) != -1) {
                    System.out.print((char) temp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (r != null) {
                    r.close();
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