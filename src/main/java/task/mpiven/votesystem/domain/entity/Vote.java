package task.mpiven.votesystem.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VOTE")
public class Vote {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "VOTE_ID")
		private Long id;

		@Column(name = "VOTE_DATE")
		private String voteDate;

		@Column(name = "USER_NAME")
		private String userName;

		@ManyToOne
		@JoinColumn(name = "RESTAURANT_ID")
		private Restaurant restaurant;

		public Vote() {
		}

		public Vote(Restaurant restaurant, String voteDate, String userName) {
			setRestaurant(restaurant);
			setVoteDate(voteDate);
			setUserName(userName);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getVoteDate() {
			return voteDate;
		}

		public void setVoteDate(String voteDate) {
			this.voteDate = voteDate;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Restaurant getRestaurant() {
			return restaurant;
		}

		public void setRestaurant(Restaurant restaurant) {
			this.restaurant = restaurant;
		}

}
