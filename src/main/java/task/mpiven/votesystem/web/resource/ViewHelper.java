package task.mpiven.votesystem.web.resource;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import task.mpiven.votesystem.service.IServiceDelegate;
import task.mpiven.votesystem.web.view.Constants;

@Component
public class ViewHelper {
	@Autowired
	protected IServiceDelegate serviceDelegate;

	public ViewHelper() {
	}

	public ModelAndView generateView(String viewName, Response response) {
		ModelAndView modelAndView = new ModelAndView(viewName);
		modelAndView.addObject(response);
		return modelAndView;
	}

	public Response getLanchMenu(RequestSettings settings) {
		Response response = new Response();
		response.setLanchMenus(serviceDelegate.getLanchMenus(settings.getRestaurantName(), settings.getCurrentDate()));
		return response;
	}

	public Response createLanchMenu(RequestSettings settings) {
		Response response = new Response();
		String status = serviceDelegate.createLanchMenu(settings.getRestaurantName(), settings.getMenuDate(),
				settings.getDishes());
		String message;
		if (status.equals(Constants.STATUS_OK)) {
			message = "Lanch Menu is created Successfully";
		} else {
			message = "Lanch Menu is NOT created";
		}
		response.setMessage(message);
		return response;
	}

	public Response voteForRestaurant(RequestSettings settings) {
		Response response = new Response();
		String status = serviceDelegate.voteForRestaurant(settings.getRestaurantId(), settings.getCurrentDate(),
				settings.getUserName());
		String message;
		if (status.equals(Constants.STATUS_OK)) {
			message = "Your vote is ACCEPTED";
		} else {
			message = "Your vote is NOT ACCEPTED, because " + status;
		}
		response.setMessage(message);
		return response;
	}

	public Response getVoteResults(RequestSettings settings) {
		Response response = new Response();
		response.setVoteResults(serviceDelegate.getVoteResult(settings.getCurrentDate()));
		return response;
	}

	public String getCurrentDate() {
		return LocalDate.now().format(Constants.DATE_FORMATTER);
	}
}
