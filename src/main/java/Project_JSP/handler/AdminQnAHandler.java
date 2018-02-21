package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.QnaBoard;
import Project_JSP.dto.QnaBoardContent;
import Project_JSP.dto.QnaView;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaBoardService;
import Project_JSP.service.QnaViewService;
import sun.print.resources.serviceui;

public class AdminQnAHandler implements CommandHandler{
	
	private static final String QNALIST = "/WEB-INF/view/adminpage/adminpage_qna.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			QnaViewService serivce = QnaViewService.getInstance();
			List<QnaView> list = serivce.selectAll();
			req.setAttribute("client", list);
			return QNALIST;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return QNALIST;
	}

}
