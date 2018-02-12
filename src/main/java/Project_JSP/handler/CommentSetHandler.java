package Project_JSP.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Comment;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.CommentService;

public class CommentSetHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		CommentService service  = CommentService.getInstance();
		Comment comment = new Comment();
		int num = Integer.parseInt(req.getParameter("num"));
		int no = Integer.parseInt(req.getParameter("no"));
		int set = Integer.parseInt(req.getParameter("set"));
		comment.setNum(num);
		if(set ==1){
			service.deleteComment(comment);
		}else if(set==2){
			String content = req.getParameter("up_content");
			String name = req.getParameter("up_name");
			comment.setContent(content);
			comment.setTime(new Date());
			comment.setWriter(name);
			service.updateComment(comment);
			
		}
		res.sendRedirect(req.getContextPath()+"/board/content.do?set=4&no="+no);
		return null;
	}
	
}
