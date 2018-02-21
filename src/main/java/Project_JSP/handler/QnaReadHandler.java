package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.QnaBoard;
import Project_JSP.dto.QnaBoardContent;
import Project_JSP.dto.QnaReply;
import Project_JSP.dto.QnaView;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaBoardContentService;
import Project_JSP.service.QnaBoardService;
import Project_JSP.service.QnaReplyService;
import Project_JSP.service.QnaViewService;

public class QnaReadHandler implements CommandHandler {
	private static final String QNADETAILVIEW = "/WEB-INF/view/mypage/qnaRecordDetailForm.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		if(req.getMethod().equalsIgnoreCase("get")){
			int num = Integer.parseInt(req.getParameter("num"));
			
			QnaBoard qnaBoard = new QnaBoard();
			qnaBoard.setQnaNum(num);
			
			QnaBoardContent qnaContent = new QnaBoardContent();
			qnaContent.setQnaNum(num);
			
			QnaBoardService service = QnaBoardService.getInstance();
			QnaBoard aqn = service.selectByNumQnaBoard(qnaBoard);
		
			QnaBoardContentService service2 = QnaBoardContentService.getInstance();
			QnaBoardContent content = service2.selectQnaBoardByNum(qnaContent);
			
			QnaReply qnaReply = new QnaReply();
			qnaReply.setNum(num);
			
			QnaReplyService service3 = QnaReplyService.getInstance();
			QnaReply reply = service3.findByNumQnaReply(qnaReply);
			
			req.setAttribute("qnaboard", aqn);
			req.setAttribute("qnaContent", content);
			req.setAttribute("reply", reply);
			
			return QNADETAILVIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return null;
	}

}
