package Project_JSP.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.dto.Comment;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.CommentService;

public class CommentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		CommentService service = CommentService.getInstance();
		int no=Integer.parseInt(req.getParameter("no"));
		Board boardNum =new Board(); 
		boardNum.setNum(no);
		String content=req.getParameter("content");
		String writer=req.getParameter("name");
		String id=req.getParameter("id");
		Comment comment = new Comment(boardNum, content, new Date(), writer,id);
		service.insertComment(comment);
		res.sendRedirect(req.getContextPath()+"/board/content.do?set=4&no="+no);
		return null;
	} 

}
