# JSP登录、注册、购物车简单实现
## 1 项目准备
  + GIT建仓库
  + 项目同步
  + 整体框架
## 2解决方案
  + Github仓库创建以及连接
  + JSP项目搭建
  + 登录、注册、修改密码的实现
  + 保存用户的用户名
  + 购物车添加商品，清除购物车并写入数据库
  + 连接本地数据库
  + 前端页面的优化处理
## 3具体实现 
  + XML封装数据库信息
    ` <context-param>
           <param-name>user</param-name>
           <param-value>root</param-value>
       </context-param>
       <context-param>
           <param-name>password</param-name>
           <param-value>123456</param-value>
       </context-param>`
   + Servlet的使用采用注入的方式使用
      `@WebServlet(name = "del", urlPatterns = {"/del.htm"})`
   + 数据库的连接以及增删改查的实现
      + 查询
      
          `String sql = "select * from new_table where user=? and password =?";  
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                 ps = con.prepareStatement(sql);
                 ps.setString(1,user);
                 ps.setString(2,pass);
                 rs = ps.executeQuery();`
      + 修改
      
        `   String sql = "UPDATE new_table set password=? WHERE user=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                   ps = con.prepareStatement(sql);
                   ps.setString(1,pass);
                   ps.setString(2,user);
                   int rs = ps.executeUpdate();`  
      + 插入    
        `  String sql = "select * from new_table where user=?";
                 try {
                     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                     ps = con.prepareStatement(sql);
                     ps.setString(1, user);
                     rs = ps.executeQuery();`  
      + 删除    
          ` String sql = "delete from product";
                       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "123456");
                       ps = con.prepareStatement(sql);
                       int rs=ps.executeUpdate();`
   + 使用Servlet的Session保存用户信息
      `   HttpSession s = request.getSession(true);
                    s.setAttribute("name",user);//设置Session
       String user = (String)s.getAttribute("name");//拿到Session中的用户信息`
   + 前端页面的的书写和接口的调用   
   + 数据库配置

    `   public void init() throws ServletException {
            //读取配置文件里面的信息
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    
            username = getServletConfig().getServletContext().getInitParameter("user");
           password = getServletConfig().getServletContext().getInitParameter("password");
            System.out.println(username);
            System.out.println(password);
        }`

## 4购物车的持续优化
  1. 在增加一个删除单个产品的接口（优化）
  2. 页面需要进一步优化
  3. 增加登出界面
  4. 增加一个人一个数据库表
  5. 前后端的分层不是太明显，需要继续改进，将前后端分离
## 5总结
  1. Jsp/servlet开发基础
  2. web前端优化（HTML5）
  3. 软件工程GIT/GITHUB和文档Markdown
  4. 使用JDBC连接数据库
  5. 实现数据库的增删查改
  6. 使用Servlet实现后台数据返回
  7. 基本java基础知识
