package ficheroAglutinador;

import java.io.Serializable;

public class Line implements Serializable {
	
	private int id;
	private int num;
	
	public Line(int id, int num) {
		this.id = id;
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
