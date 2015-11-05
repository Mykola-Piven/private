package task.mpiven.votesystem.web.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import task.mpiven.votesystem.web.resource.Response;

@Component
public class TextView implements View {

	@Override
	public String getContentType() {
		return Constants.PLAIN_TEXT;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(Constants.PLAIN_TEXT + ";" + Constants.CHARSET);
		PrintWriter writer = response.getWriter();
		Response responseString = (Response) model.get(Constants.RESPONSE);
		writer.print(responseString.getMessage());
		writer.close();
	}
}
