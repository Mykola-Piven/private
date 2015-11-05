package task.mpiven.votesystem.web.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import task.mpiven.votesystem.web.resource.Response;

@Component
public class JsonView implements View {

	@Autowired
	private JsonSerializer jsonSerializer;

	@Override
	public String getContentType() {
		return Constants.APPLICATION_JSON;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(Constants.APPLICATION_JSON + ";" + Constants.CHARSET);

		PrintWriter writer = response.getWriter();
		Response menuResponse = (Response) model.get(Constants.RESPONSE);
		if (menuResponse != null) {
			jsonSerializer.serializeResponse(menuResponse, writer);
			writer.close();
		}
	}
}
