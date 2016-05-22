package database.utils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils{
    /**
     * 获取连接
     * 
     */
    private static final String propFile = "mysql.properties";
    public static Connection getConnection()
    {
        InputStream in = null;
        Properties prop = new Properties();
        try {
            in = JDBCUtils.class.getResourceAsStream(propFile);
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取资源文件出错");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭流失败");
            }
        }
        String driverName = prop.getProperty("driverName");
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            // System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取失败");
        }
        
        return con;
        
    }
    /**
     * 关闭连接
     */
    public static void free(ResultSet rs, Statement sta, Connection con)
    {
        try {
            if (null != rs)
            {
                rs.close();
                rs = null;
            }
            
            if (null != sta)
            {
                sta.close();
                sta = null;
            }
            
            if (null != con)
            {
                con.close();
                con = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}