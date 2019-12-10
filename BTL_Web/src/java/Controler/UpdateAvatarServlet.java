/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import static Controler.UpdateCoverServlet.SAVE_DIRECTORY;
import Model.Person;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdateAvatarServlet", urlPatterns = {"/UpdateAvatarServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB

public class UpdateAvatarServlet extends HttpServlet {

    public static final String SAVE_DIRECTORY = "uploadDir";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String appPath = "C:/Users/trung/Documents/NetBeansProjects/BTL_Web/web/img/";

        // Thư mục để save file tải lên.
        String fullSavePath = "";
        if (appPath.endsWith("/")) {
            fullSavePath = appPath + SAVE_DIRECTORY;
        } else {
            fullSavePath = appPath + "/" + SAVE_DIRECTORY;
        }
        // Tạo thư mục nếu nó không tồn tại.
        File fileSaveDir = new File(fullSavePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        HttpSession hs = req.getSession();
        Person obj = (Person) hs.getAttribute("users");

        String fileName = "";
        for (Part part : req.getParts()) {
            fileName = extractFileName(part);
            System.out.println(fileName);
            if (fileName != null && fileName.length() > 0) {
                String filePath = fullSavePath + "/" + fileName;
                part.write(filePath);
            }
//            System.out.println(part);
        }
        obj.setAvatar("img/uploadDir/" + fileName);
        PersonDAO personDAO = new PersonDAO();
        personDAO.updateAvatar(obj);

        req.getRequestDispatcher("/Profile.jsp").forward(req, resp);

    }

    private String extractFileName(Part part) {
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
