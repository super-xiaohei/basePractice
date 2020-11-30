package controller;

import common.MyPage;
import domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        Class<UserServlet> userServletClass = UserServlet.class;
        try {
            UserServlet userServlet = userServletClass.newInstance();
            Method method1 = userServletClass.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            method1.invoke(userServlet,req,resp);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag = userService.register(new User(username,password));
//        if(flag){
//            resp.sendRedirect(req.getContextPath()+"/user?method=list");
//        }
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        writer.flush();
    }
    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoS = req.getParameter("pageNo");
        String pageSizeS= req.getParameter("pageSize");
        int pageNo = Integer.parseInt(pageNoS);
        int pageSize = Integer.parseInt(pageSizeS);

        MyPage<User> page = userService.listUser(new MyPage<User>(pageNo, pageSize));
        req.setAttribute("page",page);
        req.getRequestDispatcher("/user/user-list.jsp").forward(req,resp);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        boolean flag = userService.deleteById(i);
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        writer.flush();
    }
    public void selectUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        User user = userService.selectUserById(i);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        writer.print(user.toString());
        writer.flush();
    }
    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String status = req.getParameter("status");
        int i1 = Integer.parseInt(status);
        PrintWriter writer = resp.getWriter();
        Boolean flag = userService.save(new User(i,username,password,i1));
        writer.print(flag);
        writer.flush();
    }
    public void updateImg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024*1024*5);
        File file = new File(req.getServletContext().getRealPath("temp"));
        diskFileItemFactory.setRepository(file);
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem:
                    fileItems) {
                if(!fileItem.isFormField()){
                    //文件处理
                    String name = fileItem.getName();
                    String realPath = req.getServletContext().getRealPath("upload/img");
                    File uploadFile = new File(realPath +"/"+ name);
                    fileItem.write(uploadFile);
                    HttpSession session = req.getSession();
                    User user = (User) session.getAttribute("loginUser");
                    user.setUrl("/upload/img/"+name);
                    Boolean i = userService.updateImg(user);
                    session.setAttribute("loginUser",user);
                    PrintWriter writer = resp.getWriter();
                    writer.print(i);
//                    FileOutputStream fileOutputStream = new FileOutputStream(uploadFile);
//                    InputStream inputStream = fileItem.getInputStream();
//                    byte[] bs = new byte[1024];
//                    int len = 0 ;
//                    while (true){
//                        len = inputStream.read(bs);
//                        if(len==-1){
//                            break;
//                        }
//                        fileOutputStream.write(bs,0,len);
//                    }
//                    fileOutputStream.close();
                }else {
                    //普通表单的处理
                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
