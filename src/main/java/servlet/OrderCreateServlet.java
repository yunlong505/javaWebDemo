package servlet;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDAO;
import dao.OrderItemDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login.jsp");
            return;
        }

        Order o = new Order();
        o.setUser(user);
        new OrderDAO().insert(o);

        List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("list");

        for(OrderItem oi:ois){
            oi.setOrder(o);
            new OrderItemDAO().insert(oi);
        }
//        request.getSession().setAttribute("list",null);
//        response.getWriter().println("订单创建成功");


        ois.clear();
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");

    }
}
