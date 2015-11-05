package task.mpiven.votesystem.web;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import task.mpiven.votesystem.web.resource.RequestSettings;
import task.mpiven.votesystem.web.resource.Response;
import task.mpiven.votesystem.web.resource.ViewHelper;
import task.mpiven.votesystem.web.view.Constants;

@RestController
public class Controller {

	@Autowired
	protected ViewHelper viewHelper;
	
	private static final Pattern LUNCH_MENU_PATTERN = Pattern.compile("(.*),([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}),\\[(.*)\\]");
	private static final Pattern VOTE_PATTERN = Pattern.compile("(.d*),(.*)");


	@RequestMapping(value = { "/admin/lunch", "/user/lunch" }, method = RequestMethod.GET)
	public ModelAndView getLunchMenu(
			@RequestParam(value = "restaurant", required = false) String restaurantName) {
		RequestSettings settings = new RequestSettings();
		settings.setRestaurantName(restaurantName);
		settings.setCurrentDate(viewHelper.getCurrentDate());
		Response response = viewHelper.getLunchMenu(settings);
		return viewHelper.generateView(Constants.JSON_VIEW, response);
	}

	@RequestMapping(value = { "/admin/vote", "/user/vote" }, method = RequestMethod.GET)
	public ModelAndView getVoteResults() {
		RequestSettings settings = new RequestSettings();
		settings.setCurrentDate(viewHelper.getCurrentDate());
		Response response = viewHelper.getVoteResults(settings);
		return viewHelper.generateView(Constants.JSON_VIEW, response);
	}

	@RequestMapping(value = "/admin/lunch", method = RequestMethod.POST)
	public ModelAndView createLunchMenu(@RequestBody String body) {

        Matcher matcher = LUNCH_MENU_PATTERN.matcher(body);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect format of Lunch Menu param. Received: " + body);
        }
        String restaurantName = matcher.group(1);
        String menuDate = matcher.group(2);
        String dishes = matcher.group(3);
        Map<String, Double> dishMap = new HashMap<>();
		String[] dishArray = dishes.split("\\;");
		for (int i = 0; i < dishArray.length; i++) {
			String[] nameAndPrice = dishArray[i].split("\\,");
			String name = nameAndPrice[0];
			Double price = Double.parseDouble(nameAndPrice[1]);
			dishMap.put(name, price);
		}

		RequestSettings settings = new RequestSettings();
		settings.setRestaurantName(restaurantName);
		settings.setMenuDate(menuDate);
		settings.setDishes(dishMap);

		Response response = viewHelper.createLunchMenu(settings);;
		return viewHelper.generateView(Constants.TEXT_VIEW, response);
   }
 
	@RequestMapping(value = "/user/vote", method = RequestMethod.POST)
	public ModelAndView voteForRestaurant(@RequestBody String body) {
        Matcher matcher = VOTE_PATTERN.matcher(body);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect format of Vote param. Received: " + body);
        }
        Long restaurantId = Long.parseLong(matcher.group(1));
        String userName = matcher.group(2);

        RequestSettings settings = new RequestSettings();
		settings.setRestaurantId(restaurantId);;
		settings.setCurrentDate(viewHelper.getCurrentDate());;
		settings.setUserName(userName);;

		Response response = viewHelper.voteForRestaurant(settings) ;;
		return viewHelper.generateView(Constants.TEXT_VIEW, response);
	}

}