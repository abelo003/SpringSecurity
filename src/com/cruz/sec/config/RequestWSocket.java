package com.cruz.sec.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;

public class RequestWSocket {
	
	private String urlWSocket;
	
	public String getUrlWSocket() {
		return urlWSocket;
	}

	public void setUrlWSocket(String urlWSocket) {
		this.urlWSocket = urlWSocket;
	}
	
	public void sendRequestWithUser(String username){
        Map<String, String> data = new HashMap<String, String>();
        data.put("usuario", username);
        sendRequestGeneralMethod(data, username);
    }

	private void sendRequestGeneralMethod(Map<String, String> data, String username){
        try {
            Jsoup.connect(urlWSocket + new Date().getTime() + "/" + username + "/close")
                .data(data)
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
        } catch (Exception ex) {
            System.out.println("RequestWSocket  :::  " + ex.getMessage());
        }
    }
	
}
