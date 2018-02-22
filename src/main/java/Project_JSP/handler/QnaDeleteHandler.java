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

public class QnaDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int qnaNum = Integer.parseInt(req.getParameter("qnaNum"));
		
		QnaBoard qnaBoard = new QnaBoard();
		QnaBoardContent qnaBoardContent = new QnaBoardContent();
		QnaReply reply = new QnaReply();
		
		qnaBoard.setQnaNum(qnaNum);
		qnaBoardContent.setQnaNum(qnaNum);
		reply.setQnaNum(qnaNum);
		
		QnaReplyService service1 = QnaReplyService.getInstance();
		service1.deleteQnaReplyByQnaNum(reply);
		
		QnaBoardContentService service2 = QnaBoardContentService.getInstance();
		service2.deleteQnaBoardContentByQnaNum(qnaBoardContent);
		
		QnaBoardService service3 = QnaBoardService.getInstance();
		service3.deleteByNumQnaBoard(qnaBoard);
	
		return null;
	}

}
