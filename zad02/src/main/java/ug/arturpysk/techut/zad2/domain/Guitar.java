package ug.arturpysk.techut.zad2.domain;

import java.sql.*;

public class Guitar {
	
	private String producer;
	private double price;
	private Date madeDate;
	
	public Guitar(String producer, double price, Date madeDate) {
		this.producer = producer;
		this.price = price;
		this.madeDate = madeDate;
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
}
