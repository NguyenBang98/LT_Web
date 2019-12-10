/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author trung
 */
public class Function {
    
    public static String getSHAHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertByteToHex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    public static boolean CheckSqlInjection(String s){
        int index1 = s.indexOf("SELECT", 0); 
        int index2 = s.indexOf("FROM", 0); 
        int index3 = s.indexOf("WHERE", 0);
        int index4 = s.indexOf("OR", 0);
        if(index1 == -1 && index2 == -1 && index3 == -1 && index4 == -1) return true;
        else return false;
    }
   
}
