package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.QnaBoard;
import Project_JSP.dto.QnaBoardContent;
import Project_JSP.dto.QnaReply;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaBoardContentService;
import Project_JSP.service.QnaBoardService;
import Project_JSP.service.QnaReplyService;

public class AdminQnaReadHandler implements CommandHandler {
	private static final String QNAVIEW = "/WEB-INF/view/adminpage/adminQnaReadForm.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("get")){
			QnaBoard qnaBoard = new QnaBoard();
			qnaBoard.setQnaNum(Integer.parseInt(req.getParameter("num")));
			
			QnaBoardContent qnaContent = new QnaBoardContent();
			qnaContent.setQnaNum(Integer.parseInt(req.getParameter("num")));
			
			QnaReply qnaReply = new QnaReply();
			qnaReply.setQnaNum(Integer.parseInt(req.getParameter("num")));
			
			
			QnaBoardService service  = QnaBoardService.getInstance();
			QnaBoard client = service.selectByNumQnaBoard(qnaBoard);
			
			QnaBoardContentService service2 = QnaBoardContentService.getInstance();
			QnaBoardContent content = service2.selectQnaBoardByNum(qnaContent);
			
			QnaReplyService service3 = QnaReplyService.getInstance();
			QnaReply reply = service3.findByNumQnaReply(qnaReply);
			
			req.setAttribute("client", client);
			req.setAttribute("content", content);
			req.setAttribute("reply", reply);
			return QNAVIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return null;
	}

}
