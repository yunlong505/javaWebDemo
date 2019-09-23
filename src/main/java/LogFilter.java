import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class LogFilter implements Filter  {
    public void  init(FilterConfig config) throws ServletException {
        // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }
    public void  doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws java.io.IOException, ServletException {

        // 输出站点名称
    //    System.out.println("站点网址：http://www.runoob.com"+Thread.currentThread().getName());
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        System.out.println("request.getRequestURL():"+request.getRequestURL());
        System.out.println("request.getContextPath():"+request.getContextPath());
        System.out.println("request.getServletPath():"+request.getServletPath());
        System.out.println("request.getServletContext().getContextPath():"+request.getServletContext().getContextPath());
        System.out.println("request.getServletContext():"+request.getServletContext());
        System.out.println("request.getServletContext().getRealPath(\"/\"):"+request.getServletContext().getRealPath("/"));




        //通过Filter过滤器进行中文处理 ，那么所有的Servlet都不需要单独处理了。
        request.setCharacterEncoding("UTF-8");


        // 把请求传回过滤链
        chain.doFilter(request,response);
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}