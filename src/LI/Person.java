package LI;

import java.sql.*;


public class Person {
 public static Connection connection = null;
  public static PreparedStatement pstm = null;
 public   static ResultSet rs = null;
        static {
        try {
        //1连接数据库
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 使用的技术：数据库名：//ip:mysql端口/数据库名字

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");

    } catch (Exception e) {


    }}
//    public static String conncetion(String name) {
//        if (rs.next()) {
//                /*int id = rs.getInt(1);
//                String name = rs.getString(2);
//                int age = rs.getInt(3);
//*/
//
//            String user_name = rs.getString("password");
//
//            return name;
//
//            //  System.out.println("id:"+id+",name:"+name+",age"+age);
//
//        } else return "no";
//
//        return "null";
//    }
    public static boolean login(String user, String pass) throws SQLException {
        String sql = "select password from new_table where user=?";
        pstm = connection.prepareStatement(sql);
        pstm.setObject(1, user);
        rs = pstm.executeQuery();

        if (!rs.next()) {
            System.err.println("用户名不存在");
            return false;
        }
        if (!rs.getString("password").equals(pass)) {
            System.err.println("密码错误");
            return false;
        }
        System.err.println("登录成功");
        pstm.close();
        connection.close();
        return true;
    }
    public static boolean register(String user, String pass)  {
      try{  String sql = "select password from new_table where user=?";
        pstm = connection.prepareStatement(sql);
        pstm.setObject(1, user);
        rs = pstm.executeQuery();
        if (rs.next()) {
            System.err.println("用户名已存在");
            if(pstm!=null)pstm.close();
            if(connection!=null) pstm.close();
            return false;
        }
        String s="insert into new_table(user,password) value (?,?);";
        pstm = connection.prepareStatement(s);
        pstm.setObject(1, user);
        pstm.setObject(2, pass);
       int rs = pstm.executeUpdate();
        System.err.println("注册成功");

          if(pstm!=null)pstm.close();
          if(connection!=null) pstm.close();
        return true;
    }catch (Exception e){
      }
        return false;
    }
    public static void main(String[] args)  {

      // System.err.println(login("admin","admin" ));
       try {
           System.out.println(register("456", "123"));
       }catch(Exception e)
       {
           e.printStackTrace();
           System.out.println("wenti ");
       }
    }


}