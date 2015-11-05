package task.mpiven.votesystem.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DISH")
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DISH_ID")
	private Long id;

	@Column(name = "DISH_NAME")
	private String name;

	@Column(name = "DISH_PRICE")
	private Double price;

	@ManyToOne
	private LunchMenu lunchMenu;

	protected Dish() {
	}

	public Dish(String name, Double price, LunchMenu lunchMenu) {
		setName(name);
		setPrice(price);
		setLunchMenu(lunchMenu);
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LunchMenu getLunchMenu() {
		return lunchMenu;
	}

	public void setLunchMenu(LunchMenu lunchMenu) {
		this.lunchMenu = lunchMenu;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + price + "]";
	}
}
