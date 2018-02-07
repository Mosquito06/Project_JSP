package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BoardService;

public class FreeBoardHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			BoardService service = BoardService.getInstance();
			List<Board> list = service.selcetAllBoard();
			if (list.size() == 0) {
				req.setAttribute("error", "123");
			}
			req.setAttribute("boardList", list);
			return "/WEB-INF/view/adminpage/free_board.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			BoardService service = BoardService.getInstance();
			Board board = new Board();
			List<Board> list=null;
			switch (req.getParameter("search_type")) {
			case "글쓴이":
				board.setName(req.getParameter("search"));
				list = service.findByNameBoard(board);
				if (list.size() == 0) {
					req.setAttribute("error", "123");
				}
				break;
				
			default:
				break;
			}
			
			req.setAttribute("boardList", list);
			return "/WEB-INF/view/adminpage/free_board.jsp";
		}

		return null;
	}

}
