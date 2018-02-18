package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class GalleryPhotoListHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/gallery/";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return filePath + "photoList.jsp";
	}

}
