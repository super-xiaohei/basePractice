package controller;



import common.MyPage;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import domain.Product;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        Class<ProductServlet> productServletClass = ProductServlet.class;
        try {
            ProductServlet productServlet = productServletClass.newInstance();
            Method method1 = productServletClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            method1.invoke(productServlet,req,resp);
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
        String pname = req.getParameter("pname");
        Integer price = Integer.parseInt(req.getParameter("price"));
        String category_id = req.getParameter("category_id");
        String flag = req.getParameter("flag");
        Product product = new Product(pname,price,flag,category_id);
        Boolean flag1 = productService.add(product);
        PrintWriter writer = resp.getWriter();
        writer.print(flag1);
        writer.flush();
    }

    public void href(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyPage<Category> page1 = categoryService.listCategory(new MyPage<Category>(1,2147483647));
        req.setAttribute("category",page1.getList());
        req.getRequestDispatcher("/product/product-add.jsp").forward(req,resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/text;charset=utf-8");
        String pid = req.getParameter("id");
        Boolean flag = productService.deleteById(pid);
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        writer.flush();
    }

    public void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String pid = req.getParameter("pid");
        String pname = req.getParameter("pname");
        Integer price =Integer.parseInt(req.getParameter("price"));
        String flag = req.getParameter("flag");
        String category_id = req.getParameter("category_id");
        PrintWriter writer = resp.getWriter();
        Boolean flag1 = productService.save(new Product(pid,pname,price,flag,category_id));
        writer.print(flag1);
        writer.flush();
    }
    public void selectProductById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String pid = req.getParameter("id");
        Product product = productService.selectProductById(pid);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        writer.print(product.toString());
        writer.flush();
    }


    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoS = req.getParameter("pageNo");
        String pageSizeS= req.getParameter("pageSize");
        int pageNo = Integer.parseInt(pageNoS);
        int pageSize = Integer.parseInt(pageSizeS);

        MyPage<Product> page = productService.listProduct(new MyPage<Product>(pageNo, pageSize));
        req.setAttribute("page",page);
        MyPage<Category> page1 = categoryService.listCategory(new MyPage<Category>(1, 2147483647));
        req.setAttribute("category",page1.getList());
        req.getRequestDispatcher("/product/product-list.jsp").forward(req,resp);
    }
}
