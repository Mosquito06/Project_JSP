package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.dto.BoardContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BoardContentService;
import Project_JSP.service.BoardService;

public class BoardContentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardContentService service = BoardContentService.getInstance();
		BoardService boardService = BoardService.getInstance();
		int num = Integer.parseInt(req.getParameter("no"));
		Board board = new Board();
		board.setNum(num);
		board=boardService.findByNumBoard(board);
		if(req.getParameter("set").equals("0")){
			int check=board.getCheck();
			board.setCheck(check+1);
			boardService.updateBoard(board);
		}else if(req.getParameter("set").equals("1")){
			
			return "/WEB-INF/view/adminpage/boardContent.jsp";
		}else if(req.getParameter("set").equals("2")){
			boardService.deletByNumBoard(board);
			
			
			return "free_board.do";
		}
		
		BoardContent content= service.findByNum(num);
		req.setAttribute("content", content);
		req.setAttribute("board", board);
		return "/WEB-INF/view/adminpage/boardContent.jsp";
	}

	
}
