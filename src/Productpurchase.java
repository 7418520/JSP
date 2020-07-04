import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "productpurchaseServlet", urlPatterns = "/produc.htm")
public class Productpurchase extends HttpServlet {
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

        String sql = "select * from product where name=?";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", username, password);
            ps = con.prepareStatement(sql);
            ps.setString(1, product);
            rs = ps.executeQuery();
            if (rs.next()) {
                try{ String s = "UPDATE product set num=num+1 WHERE name=?";
                ps = con.prepareStatement(s);
                ps.setString(1, product);
                int rs = ps.executeUpdate();
               }
                catch(SQLException e)
                {


            } }else {
try{


                String s1 = "INSERT INTO product(name,num,price) value(?,?,?)";
                ps = con.prepareStatement(s1);
                ps.setString(1, product);
                ps.setString(2, num);
                ps.setString(3, price);
                int rs = ps.executeUpdate();}catch (SQLException e)
{

}
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    response.sendRedirect("Login/product.jsp");}
}
