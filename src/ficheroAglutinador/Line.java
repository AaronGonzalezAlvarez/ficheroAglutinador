package ficheroAglutinador;

import java.io.Serializable;

public class Line implements Serializable {
	
	private int id;
	private Long num;
	
	public Line(int id, Long num) {
		this.id = id;
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}
