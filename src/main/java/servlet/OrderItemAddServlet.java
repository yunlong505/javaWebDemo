package servlet;

import bean.OrderItem;
import bean.Product;
import dao.ProductDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemAddServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        Product product = new ProductDAO().getProduct(pid);

        OrderItem oi = new OrderItem();
        oi.setNum(num);
        oi.setProduct(product);


        List<OrderItem> list = (List<OrderItem>) request.getSession().getAttribute("list");
        if (null == list) {
            list = new ArrayList();
            request.getSession().setAttribute("list", list);
        }

        boolean found = false;
        for (OrderItem orderItem : list) {
            if (orderItem.getProduct().getId() == oi.getProduct().getId()) {
                orderItem.setNum(orderItem.getNum() + num);
                found = true;
                break;
            }
        }

        if (!found) {
            list.add(oi);
        }
        response.sendRedirect("/listOrderItem");


    }
}
