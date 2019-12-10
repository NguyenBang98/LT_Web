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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author trung
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
       maxFileSize = 1024 * 1024 * 10, // 10MB
       maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadServlet extends HttpServlet {
    
     public static final String SAVE_DIRECTORY = "uploadDir";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        String content = req.getParameter("Text1");
        System.out.println(content);
        String appPath = "C:/Users/trung/Documents/NetBeansProjects/BTL_Web/web/img/";
 
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
//                System.out.println("Write attachment to file: " + filePath);

                // Ghi vào file.
                part.write(filePath);
            }
            p = new Post(content, "img/uploadDir/" + fileName, java.time.LocalDate.now().toString());
            p.setP(obj);
//            System.out.println(fileName);
        }
        
        PostDAO pdao = new PostDAO();
        pdao.savePost(p);
//        HttpSession hs = req.getSession();
//        List<Post> list = LoadHome.loadPost();
//        Collections.reverse(list);
//        hs.setAttribute("data", list);
          
        resp.setHeader("Refresh", "1");
        resp.sendRedirect("/BTL_Web/Home");
        
        
        
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
