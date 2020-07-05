import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DelServlet", urlPatterns = "/delproduct.htm")
public class DelServlet extends HttpServlet {
    private String username;
    private String password;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        username = getServletConfig().getServletContext().getInitParameter("user");
        password = getServletConfig().getServletContext().getInitParameter("password");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        String num = request.getParameter("num");
        String price = request.getParameter("price");
        String sql = "UPDATE product set num=num-1 WHERE name=?";
        if (Integer.parseInt(num) > 1) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                ps = con.prepareStatement(sql);
                ps.setString(1, product);
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    response.sendRedirect("Login/product.jsp");
                }
            } catch (SQLException e) {

            }
        } else {
            try {
                String s = "DELETE from product where name=?";
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
                ps = con.prepareStatement(s);
                ps.setString(1, product);
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    response.sendRedirect("Login/product.jsp");
                }

            } catch (SQLException e) {

            }
        }


    }
}
