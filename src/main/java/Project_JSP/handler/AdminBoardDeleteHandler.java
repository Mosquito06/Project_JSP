package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BoardService;

public class AdminBoardDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardService service = BoardService.getInstance();

		Board board = new Board();

		String list = req.getParameter("list");
		String[] arr = list.split(",");
		for (int i = 0; i < arr.length; i++) {
			int no = Integer.parseInt(arr[i]);
			board.setNum(no);
			service.deletByNumBoard(board);
		}
		res.sendRedirect("adminBoard.do");

		return null;

	}

}
