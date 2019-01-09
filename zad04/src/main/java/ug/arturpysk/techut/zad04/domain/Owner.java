package ug.arturpysk.techut.zad04.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "owner.all", query = "Select p from Owner p"),
})
public class Owner {

	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private List<Guitar> guitars = new ArrayList<Guitar>();
	
	public Owner(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Owner() {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Guitar> getAllGuitars() {
        return guitars;
    }
    public void setAllGuitars(List<Guitar> guitars) {
        this.guitars = guitars;
    }
}
