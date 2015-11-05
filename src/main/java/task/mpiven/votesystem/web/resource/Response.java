package task.mpiven.votesystem.web.resource;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import task.mpiven.votesystem.domain.entity.LunchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private Error error;
	private List<LunchMenu> lunchMenus = Collections.emptyList();
	private String message;
	private Map<Restaurant,Integer> voteResults;

	public Response() {
		super();
	}

	public Response(Error error) {
		this();
		this.setError(error);
	}

	public List<LunchMenu> getLunchMenus() {
		return lunchMenus;
	}

	public void setLunchMenus(List<LunchMenu> lunchMenus) {
		this.lunchMenus = lunchMenus;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<Restaurant,Integer> getVoteResults() {
		return voteResults;
	}

	public void setVoteResults(Map<Restaurant,Integer> voteResults) {
		this.voteResults = voteResults;
	}

}
