package task.mpiven.votesystem.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import task.mpiven.votesystem.domain.entity.LunchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;

public interface LunchMenuRepository extends CrudRepository<LunchMenu, Long> {

	public List <LunchMenu> findByRestaurantAndMenuDate(Restaurant restaurant, String menuDate);
	public List <LunchMenu> findByMenuDate(String menuDate);
}
