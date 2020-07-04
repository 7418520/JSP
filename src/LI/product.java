package LI;

import java.sql.*;
import java.util.Vector;

public class product{
    private String username;
    private static String password;
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
   static {   try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }}
    public  static  ResultSet product()
    {try{
        String sql = "select * from product ";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "123456");
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
        return rs;
    }catch (SQLException e)
    {

    }return rs;
    }
    public  static  void Delproduct ()
    {

            try{


        String sql = "delete from product";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "123456");
        ps = con.prepareStatement(sql);
        rs=ps.executeQuery();
            }catch (SQLException e)
            {

            }
    }


}

