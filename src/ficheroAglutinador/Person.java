package ficheroAglutinador;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
	
	private int id;	
	private String name;
	private String surname;
	private String surnameTwo;
	private int phone;
	private ArrayList<Line> lines = new ArrayList(); 
	
	public Person(int id, String name, String surname, String surnameTwo, int phone) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.surnameTwo = surnameTwo;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurnameTwo() {
		return surnameTwo;
	}
	public void setSurnameTwo(String surnameTwo) {
		this.surnameTwo = surnameTwo;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public void addLine(Line line) {
		lines.add(line);
    }

    public void deleteLine(Line line) {
    	lines.remove(line);
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

}
