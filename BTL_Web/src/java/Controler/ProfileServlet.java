/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Person;
import Model.Post;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author vieet
 */
@WebServlet(name = "ProfileDAO", urlPatterns = {"/ProfileDAO"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
       maxFileSize = 1024 * 1024 * 10, // 10MB
       maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ProfileServlet extends HttpServlet {
    
     public static final String SAVE_DIRECTORY = "uploadDir";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Controler.ProfileServlet.doPost()");
        req.setCharacterEncoding("UTF-8");
//        String content = req.getParameter("Text1");
//        System.out.println(content);
        String appPath = "D:/Code/Code Java/ImageSocialNetwork/web/img/";
 
        // Thư mục để save file tải lên.
        String fullSavePath = "";
        if (appPath.endsWith("/")) {
            fullSavePath = appPath + SAVE_DIRECTORY;
        } 
        else 
        {
            fullSavePath = appPath + "/" + SAVE_DIRECTORY;
        }
         // Tạo thư mục nếu nó không tồn tại.
        File fileSaveDir = new File(fullSavePath);
        if (!fileSaveDir.exists()) 
        {
            fileSaveDir.mkdir();
        }
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//        LocalDateTime now = LocalDateTime.now();  
        Post p = new Post();
        HttpSession hs = req.getSession();
        
        Person obj = (Person)hs.getAttribute("users");
        for (Part part : req.getParts()) 
        {
            String fileName = extractFileName(part);
            if (fileName != null && fileName.length() > 0) {
                String filePath = fullSavePath + "/" + fileName;

                // Ghi vào file.
                part.write(filePath);
            }
            obj.setCover("img/uploadDir/" + fileName);

        }
        
        // update infor person to database
        
          
        resp.setHeader("Refresh", "1");
        resp.sendRedirect("/BTL_Web/Home");
        
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession hs = req.getSession();
        
        Person obj = (Person)hs.getAttribute("users");
//        System.out.println(obj);
        
        if (obj != null)
        {
            req.setAttribute("user", obj);
            req.getRequestDispatcher("/Profile.jsp").forward(req, resp);
//            resp.sendRedirect("/BTL_Web/Home.jsp");// 
        }
        else{
            req.getRequestDispatcher("/SignIn.jsp").forward(req, resp);
        }
    }
    private String extractFileName(Part part) {
       // form-data; name="file"; filename="C:\file1.zip"
       // form-data; name="file"; filename="C:\Note\file2.zip"
       String contentDisp = part.getHeader("content-disposition");
       String[] items = contentDisp.split(";");
       for (String s : items) {
           if (s.trim().startsWith("filename")) {
               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
               clientFileName = clientFileName.replace("\\", "/");
               int i = clientFileName.lastIndexOf('/');
               return clientFileName.substring(i + 1);
           }
       }
       return null;
   }
   
}
