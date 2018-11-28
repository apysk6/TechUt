package ug.arturpysk.techut.zad04.domain;
import javax.persistence.*;

@Entity
public class Producer {
	
	private long id;
	private String name;
	
	public Producer(String name) {
		this.name = name;
	}
	
	public Producer( ) {
		super();
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
