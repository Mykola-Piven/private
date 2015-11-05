package task.mpiven.votesystem.web.view;

import java.io.Writer;

import org.json.JSONException;
import org.json.JSONWriter;

import org.hibernate.type.SerializationException;
import org.springframework.stereotype.Component;

import task.mpiven.votesystem.domain.entity.Dish;
import task.mpiven.votesystem.domain.entity.LanchMenu;
import task.mpiven.votesystem.domain.entity.Restaurant;
import task.mpiven.votesystem.web.resource.Response;

@Component
public class JsonSerializer {

	public void serializeResponse(Response response, Writer writer) throws SerializationException {

		try {
			JSONWriter jsonWriter = new JSONWriter(writer);
			jsonWriter.object();
			jsonWriter.key(Constants.RESPONSE).object();
			if (response.getLanchMenus() != null && !response.getLanchMenus().isEmpty()) {
				serializeLanchMenus(response, jsonWriter);
			} else if (response.getVoteResults() != null && !response.getVoteResults().isEmpty()) {
				serializeVoteResults(response, jsonWriter);
			}
			jsonWriter.endObject();
			jsonWriter.endObject();
		} catch (JSONException e) {
			throw new SerializationException(null, e);
		}
	}

	private void serializeLanchMenus(Response response, JSONWriter jsonWriter) {
		serializeError(response, jsonWriter);
		jsonWriter.key(Constants.LANCH_MENU);
		jsonWriter.array();
		for (LanchMenu lanchMenu : response.getLanchMenus()) {
			serializeLanchMenu(lanchMenu, jsonWriter);
		}
		jsonWriter.endArray();
	}

	private void serializeLanchMenu(LanchMenu lanchMenu, JSONWriter jsonWriter) {
		jsonWriter.object();
		serializeRestaurant(lanchMenu.getRestaurant(), jsonWriter);
		serializeField(Constants.DATE, lanchMenu.getMenuDate(), jsonWriter);
		jsonWriter.key(Constants.DISH);
		jsonWriter.array();
		for (Dish dish : lanchMenu.getDish()) {
			serializeDish(dish, jsonWriter);
		}
		jsonWriter.endArray();
		jsonWriter.endObject();
	}

	private void serializeRestaurant(Restaurant restaurant, JSONWriter jsonWriter) {
		if (restaurant != null) {
			serializeField(Constants.RESTORAN_ID, restaurant.getId().toString(), jsonWriter);
			serializeField(Constants.RESTORAN_NAME, restaurant.getName(), jsonWriter);
		}
	}

	private void serializeDish(Dish dish, JSONWriter jsonWriter) {
		jsonWriter.object();
		serializeField(Constants.NAME, dish.getName(), jsonWriter);
		serializeField(Constants.PRICE, dish.getPrice().toString(), jsonWriter);
		jsonWriter.endObject();
	}

	private void serializeVoteResults(Response response, JSONWriter jsonWriter) {
		serializeError(response, jsonWriter);
		jsonWriter.key(Constants.VOTE_RESULTS);
		jsonWriter.array();
		for (Restaurant restaurant : response.getVoteResults().keySet()) {
			serializeVoteResult(restaurant, response.getVoteResults().get(restaurant), jsonWriter);
		}
		jsonWriter.endArray();
	}

	private void serializeVoteResult(Restaurant restaurant, Integer voteNumber, JSONWriter jsonWriter) {
		jsonWriter.object();
		serializeField(Constants.RESTORAN_NAME, restaurant.getName(), jsonWriter);
		serializeField(Constants.VOTE_NUMBER, voteNumber.toString(), jsonWriter);
		jsonWriter.endObject();
	}

	private void serializeError(Response response, JSONWriter jsonWriter) {
		if (response.getError() != null) {
			jsonWriter.key(Constants.ERROR);
			jsonWriter.object();
			jsonWriter.key(Constants.MESSAGE).value(response.getError().getMessage());
			jsonWriter.endObject();
		}
	}

	private void serializeField(String key, String value, JSONWriter jsonWriter) {
		if (key != null && value != null) {
			jsonWriter.key(key).value(value);
		}
	}
}
