package task.mpiven.votesystem.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESTAURANT_ID")
	private Long id;

	@Column(name = "RESTAURANT_NAME")
	private String name;
	
	protected Restaurant() {
	}

	public Restaurant(String name) {
		setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Restaurant '" + name + "'";
	}

}