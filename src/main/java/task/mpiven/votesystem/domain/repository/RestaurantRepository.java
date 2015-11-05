package task.mpiven.votesystem.domain.repository;

import org.springframework.data.repository.CrudRepository;

import task.mpiven.votesystem.domain.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

	public Restaurant findByNameIgnoreCase(String name);
	public Restaurant findById(Long id);
}
