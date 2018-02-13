package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;

public class QnAHandler implements CommandHandler{
	private static final String QNA_VIEW = "/WEB-INF/view/qna/qna_form.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return QNA_VIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			return "index.jsp";
		}
		return null;
	}

}
