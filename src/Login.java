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

@WebServlet(name = "login", urlPatterns = {"/login.htm"})
public class Login extends HttpServlet {
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
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String sql = "select * from new_table where user=? and password =?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
            ps = con.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if(rs.next())
            {
                System.err.println("登录成功");
                HttpSession s = request.getSession(true);
                s.setAttribute("name",user);
                request.getRequestDispatcher("/member.htm").forward(request,response);
            }else{
                System.err.println("登录失败，请重新登录");
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out=response.getWriter();
                out.println("<!DOCTYPE HTML>");
                out.println("<HTML>");
                out.println("<HEAD><title>欢迎登陆</title></HEAD>");
                out.println("<body>");
                out.println("<div align='center'>");
                out.println("<h2>登陆失败，请重新登陆</h2>");
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
