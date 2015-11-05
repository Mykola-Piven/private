package task.mpiven.votesystem.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import task.mpiven.votesystem.domain.entity.Restaurant;
import task.mpiven.votesystem.domain.entity.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

	public Vote findByUserNameIgnoreCaseAndVoteDate(String userName, String voteDate);
	public Integer countRestaurantByRestaurantAndVoteDate(Restaurant restaurant, String voteDate);
	public List<Vote> findDistinctRestaurantByVoteDate(String voteDate);
}
