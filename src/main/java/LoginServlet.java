import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String passWord = request.getParameter("passWord");
        if ("admin".equals(account) && "123".equals(passWord)) {
            System.out.println("*" + account + "*");
            System.out.println("*" + passWord + "*");
            request.getSession().setAttribute("account", account);
            request.getSession().setAttribute("passWord", passWord);
            System.out.println(request.getSession().getAttribute("account"));
              response.sendRedirect("listHero");
       //     request.getRequestDispatcher("/listHero").forward(request, response);
        } else {
            System.out.println("*" + account + "*222");
            System.out.println("*" + passWord + "*333");
                 response.sendRedirect("login.html");
         //   request.getRequestDispatcher("/login.html").forward(request, response);
        }


    }
}

