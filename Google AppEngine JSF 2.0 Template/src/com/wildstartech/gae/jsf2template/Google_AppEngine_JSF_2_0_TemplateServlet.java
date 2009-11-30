package com.wildstartech.gae.jsf2template;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Google_AppEngine_JSF_2_0_TemplateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
