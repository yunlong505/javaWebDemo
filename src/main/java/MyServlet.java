import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

@WebServlet
public class MyServlet extends HttpServlet {
    private String message;
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        // 执行必需的初始化
        message = "Hello World222";
    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//    {
//        // 如果不存在 session 会话，则创建一个 session 对象
//        HttpSession session = request.getSession(true);
//
//        // 获取 session 创建时间
//        Date createTime = new Date(session.getCreationTime());
//        // 获取该网页的最后一次访问时间
//        Date lastAccessTime = new Date(session.getLastAccessedTime());
//
//        //设置日期输出的格式
//        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String title = "Servlet Session 实例 - 菜鸟教程";
//        Integer visitCount = new Integer(0);
//        String visitCountKey = new String("visitCount");
//        String userIDKey = new String("userID");
//        String userID = new String("Runoob");
//        if(session.getAttribute(visitCountKey) == null) {
//            session.setAttribute(visitCountKey, new Integer(0));
//        }
//
//
//        // 检查网页上是否有新的访问者
//        if (session.isNew()){
//            title = "Servlet Session 实例 - 菜鸟教程";
//            session.setAttribute(userIDKey, userID);
//        } else {
//            visitCount = (Integer)session.getAttribute(visitCountKey);
//            visitCount = visitCount + 1;
//            userID = (String)session.getAttribute(userIDKey);
//        }
//        session.setAttribute(visitCountKey,  visitCount);
//
//        // 设置响应内容类型
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String docType = "<!DOCTYPE html>\n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><title>" + title + "</title></head>\n" +
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<h2 align=\"center\">Session 信息</h2>\n" +
//                "<table border=\"1\" align=\"center\">\n" +
//                "<tr bgcolor=\"#949494\">\n" +
//                "  <th>Session 信息</th><th>值</th></tr>\n" +
//                "<tr>\n" +
//                "  <td>id</td>\n" +
//                "  <td>" + session.getId() + "</td></tr>\n" +
//                "<tr>\n" +
//                "  <td>创建时间</td>\n" +
//                "  <td>" +  df.format(createTime) +
//                "  </td></tr>\n" +
//                "<tr>\n" +
//                "  <td>最后访问时间</td>\n" +
//                "  <td>" + df.format(lastAccessTime) +
//                "  </td></tr>\n" +
//                "<tr>\n" +
//                "  <td>用户 ID</td>\n" +
//                "  <td>" + userID +
//                "  </td></tr>\n" +
//                "<tr>\n" +
//                "  <td>访问统计：</td>\n" +
//                "  <td>" + visitCount + "</td></tr>\n" +
//                "</table>\n" +
//                "</body></html>");
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if ("admin".equals(name) && "123".equals(password)) {
            request.getRequestDispatcher("success.html").forward(request, response);
        } else {
            //  request.getRequestDispatcher("fail.html").forward(request,response);
            response.sendRedirect("fail.html");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setDateHeader("Expires", 0);
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("pragma", "no-cache");

        String fileName = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置上传文件的大小限制为1M
        factory.setSizeThreshold(1024 * 1024);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) {
                // 根据时间戳创建头像文件
                fileName = System.currentTimeMillis() + ".jpg";
                //通过getRealPath获取上传文件夹，如果项目在e:/project/j2ee/web,那么就会自动获取到 e:/project/j2ee/web/uploaded
                String photoFolder = request.getServletContext().getRealPath("uploaded");
                //创建以photoFolder为路径的文件fileName
                File f = new File(photoFolder, fileName);
                //获取文件f的父目录,并创建多层目录,不用getParentFile()的话获得都是文件夹
                f.getParentFile().mkdirs();
                // 通过item.getInputStream()获取浏览器上传的文件的输入流
                InputStream is = item.getInputStream();
                // 复制文件
                FileOutputStream fos = new FileOutputStream(f);
                byte b[] = new byte[1024 * 1024];
                int length = 0;
                while (-1 != (length = is.read(b))) {
                    fos.write(b, 0, length);
                }
                fos.close();
            }
            else {
                System.out.println(item.getFieldName());
                String value = item.getString();
                value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
                System.out.println(value);
            }
        }
        String html = "<img width='200' height='150' src='uploaded/%s' />";
        response.setContentType("text/html");
        PrintWriter pw= response.getWriter();
        pw.format(html,fileName);
    }
}
