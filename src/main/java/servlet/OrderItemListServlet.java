package servlet;

import bean.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderItemListServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //下一个jsp文件直接在session中就可以取到了,没必要在加入request中
//        List<OrderItem> list = (List<OrderItem>) request.getSession().getAttribute("list");
//        request.setAttribute("list",list);

        request.getRequestDispatcher("listOrderItem.jsp").forward(request,response);
    }
}
