/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "SendEmail", urlPatterns = {"/SendEmail"})
public class SendEmail {

    public static String send(String to) throws IOException {

        String from = "tkInfinity.ptit@gmail.com";
        String password = "@aA123456789";

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message
        String genCode = Utils.RequestAPI.find(Utils.RequestAPI.POSTRequest());
//            String genCode = genCode();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Update Password");
            message.setText("Your confirm code: " + genCode);

        //send message
            Transport.send(message);

            System.out.println("message sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return genCode;
    }
    
    
    public static String genCode(){
        
        // gen code to send to customer email
        
        Random r = new Random();
        
        String gen = "";
        for(int i=1; i<=4; i++){
            gen += ""+r.nextInt(10);
        }
        
        return "" + gen;
    }
    public static boolean CheckSqlInjection(String s){
        if(s =="' OR 1 = 1; --" || s =="‘ or ‘abc‘=‘abc‘;--" || s =="‘ or ‘ ‘=‘ ‘;--") return false;
        else return true;
    }

    
}
