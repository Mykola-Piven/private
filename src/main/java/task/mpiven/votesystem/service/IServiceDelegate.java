package task.mpiven.votesystem.service;

import java.util.List;
import java.util.Map;

import task.mpiven.votesystem.domain.entity.LanchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;

public interface IServiceDelegate {

	public List<LanchMenu> getLanchMenus(String restaurantName, String menuDate);
	public String createLanchMenu(String restaurantName, String menuDate, Map<String, Double> dishes);
	public String voteForRestaurant(Long restaurantId, String currentDate, String userName);
	public Map<Restaurant,Integer> getVoteResult(String currentDate);
}
