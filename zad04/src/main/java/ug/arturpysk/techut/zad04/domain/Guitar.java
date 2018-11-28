package ug.arturpysk.techut.zad04.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Guitar {
	
	private long id;
	private double price;
	private Date madeDate;
	private boolean isReserved;
	
	private Producer producer;
	private List<Owner> owners = new ArrayList<Owner>();
	private Serial serial;
	
	public Guitar () {
	}
	
	public Guitar(Producer producer, double price, Date madeDate, boolean isReserved, List<Owner> owners, Serial serial) {
		this.producer = producer;
		this.price = price;
		this.madeDate = madeDate;
		this.isReserved = isReserved;
		this.owners = owners;
		this.serial = serial;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	//Producer can have many guitars.
	@ManyToOne
	public Producer getProducer() {
		return producer;
	}
	
	public void setProducer(Producer producer) {
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

	//One guitar can have many owners.
	@OneToMany
	public List<Owner> getOwners() {
		return owners;
	}

	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	//One guitar can have one serial number.
	@OneToOne
	public Serial getSerial() {
		return serial;
	}

	public void setSerial(Serial serial) {
		this.serial = serial;
	}
}
