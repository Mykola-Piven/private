package task.mpiven.votesystem.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import task.mpiven.votesystem.domain.entity.LanchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;

public interface LanchMenuRepository extends CrudRepository<LanchMenu, Long> {

	public List <LanchMenu> findByRestaurantAndMenuDate(Restaurant restaurant, String menuDate);
	public List <LanchMenu> findByMenuDate(String menuDate);
}
