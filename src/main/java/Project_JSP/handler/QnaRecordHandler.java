package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class QnaRecordHandler implements CommandHandler {
	private static final String QNALISTVIEW = "/WEB-INF/view/mypage/qnaRecordForm.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		if(req.getMethod().equalsIgnoreCase("get")){
			return QNALISTVIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return null;
	}

}
