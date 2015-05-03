package by.julia.spring.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARDS")
public class Card {
	
	private int id;
	
	
	private Count count;
	private boolean status;
	private User user;
	
	
	@Id
	@GeneratedValue
	@Column(name = "CARD_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Count.class)
	@JoinColumn(name = "COUNT_ID")
	public Count getCount() {
		return count;
	}
	public void setCount(Count count) {
		this.count = count;
	}
	
	
	@Column(name = "ACTIVE_STATUS")
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
