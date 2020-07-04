import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "memberServlet", urlPatterns = {"/member.htm"})
public class MemberServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<!DOCTYPE HTML>");
        out.println("<HTML>");
        out.println("<HEAD><title>欢迎登陆</title></HEAD>");
        out.println("<body>");
      out.println("<div align='center'>");
        out.println("<h2>欢迎登陆"+request.getParameter("username")+"</h2>");
        out.println("<a href=\"Login/product.jsp\">选购商品</a>");
        out.println("<a href=\"Login/update.jsp\">修改密码</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</HTML>");
    }


}
