package by.julia.spring.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTS")
public class Count {
	private int id;
	private float value;
	
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Id
	@GeneratedValue
	@Column(name = "COUNT_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
