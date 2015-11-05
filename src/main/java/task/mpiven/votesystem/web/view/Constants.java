package task.mpiven.votesystem.web.view;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Constants {
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public static final LocalTime FINISH_VOTE_TIME = LocalTime.of(11, 00);
	public static final String APPLICATION_JSON = "application/json";
	public static final String PLAIN_TEXT = "text/plain";
	public static final String CHARSET = "charset=utf-8";
	public static final String JSON_VIEW = "jsonView";
	public static final String TEXT_VIEW = "textView";
	public static final String STATUS_OK = "OK!";
	public static final String STATUS_FAIL = "FAIL!!!";
	public static final String RESPONSE = "response";
	public static final String LUNCH_MENU = "lunch_menu ";
	public static final String ERROR = "error";
	public static final String MESSAGE = "message";
	public static final String DATE = "date";
	public static final String DISH = "dish";
	public static final String RESTORAN_ID = "restoran_id";
	public static final String RESTORAN_NAME = "restoran_name";
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String VOTE_RESULTS = "vote_results";
	public static final String VOTE_NUMBER = "vote_number";

}
