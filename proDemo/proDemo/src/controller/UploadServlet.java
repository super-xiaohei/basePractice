package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录。
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setSizeThreshold(1024*1024*5);
        File file = new File("proDemo/web/temp");
        diskFileItemFactory.setRepository(file);
//2、使用DiskFileItemFactory 对象创建ServletFileUpload对象，并设置上传文件的大小限制。
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
//3、调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象。
        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            //4、对list进行迭代，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件：
            for (FileItem fileItem:
                 fileItems) {
                if(fileItem.isFormField()){
                    System.out.println("不是文件");
                    System.out.println(fileItem.getFieldName());
                    System.out.println(fileItem.getString());
                }else {
                    System.out.println("是文件");
                    System.out.println(fileItem.getContentType());
                    String name = fileItem.getName();
                    File uploadFile = new File("proDemo/web/upload" + name);
                    //fileItem.write(uploadFile);
                    FileOutputStream fileOutputStream = new FileOutputStream(uploadFile);
                    InputStream inputStream = fileItem.getInputStream();
                    byte[] bs = new byte[1024];
                    int len = 0 ;
                    while (true){
                        len = inputStream.read(bs);
                        if(len==-1){
                            break;
                        }
                        fileOutputStream.write(bs,0,len);
                    }
                    fileOutputStream.close();
                }

            }
//4.1、 为普通表单字段，则调用getFieldName、getString方法得到字段名和字段值。

//4.2、为上传文件，则调用getInputStream方法得到数据输入流，从而读取上传数据。
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }
}
