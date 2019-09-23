package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hero;
import dao.HeroDAO;

public class HeroListServlet extends HttpServlet {


    //不用mvc模式的写法
//    protected void service(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html; charset=UTF-8");
//
//        List<Hero> heros = new HeroDAO().list();
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
//        sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td></tr>\r\n");
//
//        String trFormat = "<tr><td>%d</td><td>%s</td><td>%.2f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
//
//        for (Hero hero : heros) {
//            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(),hero.getId(),hero.getId());
//            sb.append(tr);
//        }
//
//        sb.append("</table>");
//
//        response.getWriter().write(sb.toString());
//
//    }
    //用mvc模式的写法
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("****" + session.getAttribute("account") + "****222");
        String account = (String) request.getSession().getAttribute("account");
        if (null == account) {
            System.out.println("1");
         //   request.getRequestDispatcher("login.html").forward(request, response);
              response.sendRedirect("login.html");
        } else {
            response.setContentType("text/html; charset=UTF-8");

            int start = 0;
            int count = 2;
            int last;

            try {
                start = Integer.parseInt(request.getParameter("start"));
            } catch (NumberFormatException e) {
                // 当浏览器没有传参数start时
                // System.out.println("当浏览器没有传参数start时" + Integer.parseInt(request.getParameter("start")));
            }
            int total = new HeroDAO().getTotal();

            int pre = start - count;
            pre = pre < 0 ? 0 : pre;

            if (0 == total % count) {
                last = total - count;
            } else {
                last = total - total % count;
            }

            int next = start + count;
            next = next > last ? last : next;

            List<Hero> heros = new HeroDAO().list(start, count);

            request.setAttribute("heros", heros);
            request.setAttribute("next", next);
            request.setAttribute("pre", pre);
            request.setAttribute("last", last);

            request.getRequestDispatcher("listHero.jsp").forward(request, response);
        }
    }


}