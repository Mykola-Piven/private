package task.mpiven.votesystem.service.impl;

import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.mpiven.votesystem.domain.entity.Dish;
import task.mpiven.votesystem.domain.entity.LunchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;
import task.mpiven.votesystem.domain.entity.Vote;
import task.mpiven.votesystem.domain.repository.DishRepository;
import task.mpiven.votesystem.domain.repository.LunchMenuRepository;
import task.mpiven.votesystem.domain.repository.RestaurantRepository;
import task.mpiven.votesystem.domain.repository.VoteRepository;
import task.mpiven.votesystem.service.IServiceDelegate;
import task.mpiven.votesystem.web.view.Constants;

@Service//("lunchMenuService")
public class ServiceDelegateImpl implements IServiceDelegate {

	@Autowired
	private LunchMenuRepository lunchMenuRepository;
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private DishRepository dishRepository;
	@Autowired
	private VoteRepository voteRepository;

	@Override
	public List<LunchMenu> getLunchMenus(String restaurantName, String menuDate) {
		List<LunchMenu> result = Collections.emptyList();
		if (restaurantName != null && !restaurantName.isEmpty()) {
			Restaurant restaurant = restaurantRepository.findByNameIgnoreCase(restaurantName);
			result = (List<LunchMenu>) lunchMenuRepository.findByRestaurantAndMenuDate(restaurant, menuDate);
		} else {
			result = (List<LunchMenu>) lunchMenuRepository.findByMenuDate(menuDate);
		}
		return result;
	}

	@Override
	public String createLunchMenu(String restaurantName, String menuDate, Map<String, Double> dishMap) {
		String status = Constants.STATUS_FAIL;
		if (restaurantName != null && restaurantName != null && dishMap != null && !restaurantName.isEmpty()
				&& !menuDate.isEmpty() && !dishMap.isEmpty()) {
			Restaurant restaurant = restaurantRepository.findByNameIgnoreCase(restaurantName);
			if (restaurant == null) {
				restaurant = new Restaurant(restaurantName);	
				restaurantRepository.save(restaurant);
			}
			LunchMenu lunchMenu = new LunchMenu(menuDate, restaurant);
			Set<Dish> dishSet = new HashSet<>();
			for (String dishName : dishMap.keySet()) {
				Dish dish = new Dish(dishName, dishMap.get(dishName), lunchMenu);
				dishSet.add(dish);
			}
			lunchMenuRepository.save(lunchMenu);
			dishRepository.save(dishSet);
			status = Constants.STATUS_OK;
		}
		return status;
	}

	@Override
	public String voteForRestaurant(Long restaurantId, String voteDate, String userName) {
		String status = Constants.STATUS_FAIL;
		if (restaurantId != null && voteDate != null && userName != null && restaurantId > 0 && !voteDate.isEmpty()
				&& !userName.isEmpty()) {
			// User Vote verification
			Vote userVote = voteRepository.findByUserNameIgnoreCaseAndVoteDate(userName, voteDate);
			if (userVote != null) { // User have been vote already
				if (LocalTime.now().isBefore(Constants.FINISH_VOTE_TIME)) { // But User can change own vote till FINISH Vote Time
					voteRepository.delete(userVote);
					status = voteForRestaurantInternal(restaurantId, voteDate, userName);
				} else {
					status = "Your have been voted today";
				}
			} else {
				status = voteForRestaurantInternal(restaurantId, voteDate, userName);
			}
		}
		return status;
	}

	private String voteForRestaurantInternal(Long restaurantId, String voteDate, String userName) {
		String status = "Current restaurant is absend";
		Restaurant restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant != null) {
			Vote vote = new Vote(restaurant, voteDate, userName);
			voteRepository.save(vote);
			status = Constants.STATUS_OK;
		}
		return status;
	}

	@Override
	public Map<Restaurant, Integer> getVoteResult(String currentDate) {
		Map<Restaurant, Integer> resultMap = new HashMap<>(); 
		List<Restaurant> restaurantList = (List<Restaurant>) restaurantRepository.findAll();
		for (Restaurant restaurant : restaurantList) {
			int value = voteRepository.countRestaurantByRestaurantAndVoteDate(restaurant, currentDate);
			resultMap.put(restaurant, value);
		}
		return resultMap;
	}
}
