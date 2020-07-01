package LI;

import java.sql.*;
import java.*;


public class Person {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;

        try {
            //1连接数据库
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 使用的技术：数据库名：//ip:mysql端口/数据库名字

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");

            //2.编写？sql

            String sql ="select * from new_table where id=?";

            //3.预编译

            pstm = connection.prepareStatement(sql);

            //4.填充占位符
            pstm.setObject(1,"1");

            //5.执行
            rs = pstm.executeQuery();

            //6判断是否有值，然后打印
            if(rs.next()){
                /*int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
*/

                String name = rs.getString("password");



                System.out.println(name);

                //  System.out.println("id:"+id+",name:"+name+",age"+age);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

//    static  {
//        map.put("admin","admin");
//
//    }
//
//    public static boolean login(String user, String pass) {
//        if (map.get(user) == null) {
//            System.err.println("用户名不存在");
//            return false;
//        }
//        if (!map.get(user).equals(pass)) {
//            System.err.println("密码错误");
//            return false;
//        }
//        System.err.println("登录成功");
//        return true;
//    }
//    public static boolean register(String user, String pass) {
//        if (map.get(user) != null) {
//            System.err.println("用户名已存在");
//            return false;
//        }
//      map.put(user,pass);
//        System.err.println("注册成功");
//        return true;
//    }
//    public static void main(String[] args) {
//
////        System.err.println(login("admin","admin"));
////    }


