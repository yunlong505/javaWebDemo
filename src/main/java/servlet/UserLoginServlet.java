package servlet;

import bean.User;
import dao.UserDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        User user=new UserDAO().getUser(name,password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/listProduct");
        }
        else {
            response.sendRedirect("/login.jsp");
        }
    }
}
