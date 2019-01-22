package ug.arturpysk.techut.zad04.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Producer {
	
	private long id;
	private String name;
	private List<Guitar> guitars = new ArrayList<Guitar>();
	
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Guitar> getGuitars() {
		return guitars;
	}
	
	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}
}
