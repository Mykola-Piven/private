package task.mpiven.votesystem.web.resource;

import java.util.Map;

public class RequestSettings {
	private String restaurantName;
	private Long restaurantId;
	private String menuDate;
	private String currentDate;
	private String userName;
	private Map<String, Double> dishes;
	
	public RequestSettings() {
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(String menuDate) {
		this.menuDate = menuDate;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Double> getDishes() {
		return dishes;
	}

	public void setDishes(Map<String, Double> dishes) {
		this.dishes = dishes;
	}


}
