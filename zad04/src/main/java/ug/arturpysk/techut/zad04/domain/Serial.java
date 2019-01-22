package ug.arturpysk.techut.zad04.domain;

import javax.persistence.*;

@Entity
public class Serial {
	private long id;
	private long serialNumber;
	
	public Serial(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
}
