package com.cruz.sec.controller;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;


@Controller
public class PruebaController {

    
}

class Stock implements Serializable {

	  private static final long serialVersionUID = 1L;
	  private String code = "";
	  private double price = 0.0;
	  private Date time = new Date();
	  
	  public Stock() {
	    
	  }
	  
	  public Stock(String code, double price) {
	    this.code = code;
	    this.price = price;
	  }
	  
	  private DateFormat df = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss");
	  
	  public String getTimeStr() {
	    return df.format(time);
	  }
	  
	  public String getCode() {
	    return code;
	  }
	  public void setCode(String code) {
	    this.code = code;
	  }
	  public double getPrice() {
	    return price;
	  }
	  public void setPrice(double price) {
	    this.price = price;
	  }
	  public Date getTime() {
	    return time;
	  }
	  public void setTime(Date time) {
	    this.time = time;
	  }

	  @Override
	  public String toString() {
	    return "Stock [code=" + code + ", price=" + price + ", time=" + getTimeStr() + "]";
	  }
	  
	  
	}
