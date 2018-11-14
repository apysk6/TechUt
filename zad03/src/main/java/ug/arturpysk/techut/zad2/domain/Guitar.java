package ug.arturpysk.techut.zad2.domain;

import java.sql.*;

public class Guitar {
	
	private String producer;
	private double price;
	private Date madeDate;
	private boolean isReserved;
	
	public Guitar () {
	}
	
	public Guitar(String producer, double price, Date madeDate, boolean isReserved) {
		this.producer = producer;
		this.price = price;
		this.madeDate = madeDate;
		this.isReserved = isReserved;
	}
	
	public String getProducer() {
		return producer;
	}
	
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getMadeDate() {
		return madeDate;
	}
	
	public void setMadeDate(Date madeDate) {
		this.madeDate = madeDate;
	}
	
	public boolean getIsReserved() {
		return isReserved;
	}
	
	public void setIsReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
}
