package task.mpiven.votesystem.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "LAUNCH_MENU")
public class LanchMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LAUNCH_MENU_ID")
	private Long id;

	@Column(name = "LAUNCH_MENU_DATE")
	private String menuDate;

	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;

	@OneToMany(mappedBy = "lanchMenu")
	@Fetch(FetchMode.JOIN)
	private Set<Dish> dish;

	protected LanchMenu() {
	}

	public LanchMenu(String lanchMenuDate, Restaurant restaurant) {
		setMenuDate(lanchMenuDate);
		setRestaurant(restaurant);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<Dish> getDish() {
		return dish;
	}

	public void setDish(Set<Dish> dish) {
		this.dish = dish;
	}

	@Override
	public String toString() {
		return "LanchMenu [Restaurant=" + restaurant + ", Data=" + menuDate + ", Dishes=" + dish + "]";
	}

}
