package task.mpiven.votesystem.domain.repository;

import org.springframework.data.repository.CrudRepository;

import task.mpiven.votesystem.domain.entity.Dish;

public interface DishRepository extends CrudRepository<Dish, Long> {

}
