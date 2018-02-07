package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BoardService;


public class FreeBoardHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			BoardService service = BoardService.getInstance();
			List<Board> list = service.selcetAllBoard();
			req.setAttribute("boardList", list);
			return "/WEB-INF/view/adminpage/free_board.jsp";
		}
		
		
		return null;
	}



}
