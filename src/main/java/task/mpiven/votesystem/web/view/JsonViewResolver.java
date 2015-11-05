package task.mpiven.votesystem.web.view;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@Component
public class JsonViewResolver implements ViewResolver {

	@Autowired
	private JsonView jsonView;
	@Autowired
	private TextView textView;

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		if (Constants.TEXT_VIEW.equalsIgnoreCase(viewName)) {
			return textView;
		} else {
			return jsonView;
		}
	}
}
