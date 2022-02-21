package com.project.HMF.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;


public class SmsPanel {
    public static String sendSms(String mob, String sms) throws IOException, KeyManagementException, NoSuchAlgorithmException {

        String message= URLEncoder.encode(sms, "UTF-8");
        URL url2 = new URL("https://www.sms4power.com/custLogin.asp?user=t1bari9191&password=24638274&msisdn="+mob+"&sid=DEALGC&msg="+message+"&fl=0&gwid=2");
        HttpURLConnection con = (HttpURLConnection) url2.openConnection();
        con.addRequestProperty("User-Agent", "Mozilla/4.76");
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        con.getOutputStream();
        con.getInputStream();
        BufferedReader rd;
        String line;
        String result = "";
        rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while ((line = rd.readLine()) != null)
        {
            result += line;
        }
        rd.close();
        System.out.println("Server Response: " + result);
        return result;

    }
}
