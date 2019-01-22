package ug.arturpysk.techut.zad04.domain;
import javax.persistence.*;

@Entity
public class Bag {

	private long id;
	private String color;
	private int width;
	private int height;
	
	public Bag(String color, int width, int height) {
		this.setColor(color);
		this.setWidth(width);
		this.setHeight(height);
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
