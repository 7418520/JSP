import com.mysql.cj.Session;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "updateServlet", urlPatterns = {"/update.htm"})
public class UpdateServlet extends HttpServlet{
    private String username;
    private String password;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void init() throws ServletException {
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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession(false);
        String user = (String)s.getAttribute("name");
        System.err.println(user);
        String pass = request.getParameter("password");
        String sql = "UPDATE new_table set password=? WHERE user=?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
            ps = con.prepareStatement(sql);
            ps.setString(1,pass);
            ps.setString(2,user);
            int rs = ps.executeUpdate();
            if(rs>0)
            {
                System.err.println("修改成功");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>欢迎登陆</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>修改成功，请登录</h2>");
                out.println("<a href=\"Login/login.jsp\">登陆</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</HTML>");
            }else{
                System.err.println("修改失败，请重新修改");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>欢迎登陆</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>修改失败，请重新修改</h2>");
                out.println("<a href=\"Login/login.jsp\">返回重新登陆</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</HTML>");
                //response.sendRedirect("Login/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
