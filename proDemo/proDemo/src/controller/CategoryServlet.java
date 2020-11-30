package controller;

import common.MyPage;
import domain.Category;
import domain.User;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        Class<CategoryServlet> categoryServletClass = CategoryServlet.class;
        try {
            CategoryServlet categoryServlet = categoryServletClass.newInstance();
            Method method1 = categoryServletClass.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            method1.invoke(categoryServlet,req,resp);
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
        req.setCharacterEncoding("utf-8");
        String cname = req.getParameter("cname");
        Boolean flag = categoryService.add(cname);
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        writer.flush();
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/text;charset=utf-8");
        String cid = req.getParameter("id");
        Boolean flag = categoryService.deleteById(cid);
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        writer.flush();
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String cid = req.getParameter("cid");
        String cname = req.getParameter("cname");
        PrintWriter writer = resp.getWriter();
        Boolean flag = categoryService.save(new Category(cid,cname));
        writer.print(flag);
        writer.flush();
    }

    public void selectCategoryById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        Category category = categoryService.selectCategoryById(id);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        writer.print(category.toString());
        writer.flush();
    }


    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoS = req.getParameter("pageNo");
        String pageSizeS= req.getParameter("pageSize");
        int pageNo = Integer.parseInt(pageNoS);
        int pageSize = Integer.parseInt(pageSizeS);

        MyPage<Category> page = categoryService.listCategory(new MyPage<Category>(pageNo, pageSize));
        req.setAttribute("page",page);
        req.getRequestDispatcher("/category/category-list.jsp").forward(req,resp);
    }
}
