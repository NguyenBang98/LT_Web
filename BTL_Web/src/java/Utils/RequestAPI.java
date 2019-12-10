/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author trung
 */
public class RequestAPI {

//    public static void main(String[] args) throws IOException {
////        MyGETRequest();
//        String res = POSTRequest();
//        find(res);
//
//    }

    public static String MyGETRequest() throws IOException {
        URL urlForGetRequest = new URL("http://0.0.0.0:5000/gencode");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
  
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
            // print result
            System.out.println("JSON String Result " + response.toString());
            return response.toString();
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
            return "GET NOT WORKED";
        }
        
    }

    public static String POSTRequest() throws IOException {
        final String POST_PARAMS = "{ \"option\" : \"pass\" } ";
        System.out.println(POST_PARAMS);
        URL obj = new URL("http://0.0.0.0:5000/gencode");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");

        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        System.out.println("POST Response Code :  " + responseCode);
        System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("POST NOT WORKED");
            return "POST NOT WORKED";
        }
    }
    public static String find(String getpass)
    {
       String[] pass = getpass.split(": \"");
       String [] pass1 = pass[1].split("\"}");
        System.out.println(pass1[0]);
        return pass1[0];
    }
    
}
