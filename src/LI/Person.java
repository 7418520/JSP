package LI;

import java.util.HashMap;

public class Person {
    static HashMap<String,String>map=new HashMap<>();

    static  {
        map.put("admin","admin");

    }

    public static boolean login(String user, String pass) {
        if (map.get(user) == null) {
            System.err.println("用户名不存在");
            return false;
        }
        if (!map.get(user).equals(pass)) {
            System.err.println("密码错误");
            return false;
        }
        System.err.println("登录成功");
        return true;
    }
    public static boolean register(String user, String pass) {
        if (map.get(user) != null) {
            System.err.println("用户名已存在");
            return false;
        }
      map.put(user,pass);
        System.err.println("注册成功");
        return true;
    }
    public static void main(String[] args) {

        System.err.println(login("admin","admin"));
    }

}
