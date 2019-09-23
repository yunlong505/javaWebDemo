package servlet;

import bean.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class OrderItemDeleteServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderItem> list = (List<OrderItem>) request.getSession().getAttribute("list");
        int pid = Integer.parseInt(request.getParameter("id"));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProduct().getId() == pid) {
                list.remove(i);
                break;
            }
        }
        request.getRequestDispatcher("/listOrderItem.jsp").forward(request, response);
    }
}
