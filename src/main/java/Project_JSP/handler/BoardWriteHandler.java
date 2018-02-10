package Project_JSP.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.dto.BoardContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BoardService;

public class BoardWriteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			
			return "/WEB-INF/view/adminpage/free_board_form.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String name = req.getParameter("name");
			String email = req.getParameter("email1")+"@"+req.getParameter("email2");
			String tell = req.getParameter("tell");
			Board board = new Board(name,  email,  tell,  title,new Date());
					
			BoardContent content2 =new BoardContent(board, content);
			BoardService service = BoardService.getInstance();
			service.insertBoard(board, content2);
			
			res.sendRedirect("free_board.do");
			return null;
		}
		return null;
	}

}
