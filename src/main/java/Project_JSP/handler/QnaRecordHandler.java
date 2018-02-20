package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Post;
import Project_JSP.dto.QnaBoard;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaBoardService;

public class QnaRecordHandler implements CommandHandler {
	private static final String QNALISTVIEW = "/WEB-INF/view/mypage/qnaRecordForm.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return QNALISTVIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			QnaBoard qnaBoard = new QnaBoard();
			qnaBoard.setId(req.getParameter("id"));
			QnaBoardService service = QnaBoardService.getInstance();
			List<QnaBoard> list =  service.selectAllQnaBoardById(qnaBoard);
			ObjectMapper om = new ObjectMapper();
			
			String json = om.writeValueAsString(list);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(json);
			pw.flush(); //고객에게 돌려줌
		}
		return null;
	}

}
