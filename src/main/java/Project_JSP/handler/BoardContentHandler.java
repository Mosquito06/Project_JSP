package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Board;
import Project_JSP.dto.BoardContent;
import Project_JSP.dto.Comment;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.BoardContentService;
import Project_JSP.service.BoardService;
import Project_JSP.service.CommentService;

public class BoardContentHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardContentService service = BoardContentService.getInstance();
		BoardService boardService = BoardService.getInstance();
		Board board = new Board();
		
		int num = Integer.parseInt(req.getParameter("no"));
		board.setNum(num);
		board=boardService.findByNumBoard(board);
		
		if(req.getMethod().equalsIgnoreCase("get")){
			
			if(req.getParameter("set").equals("0")){
				int check=board.getCheck();
				board.setCheck(check+1);
				boardService.updateBoard(board);
			}else if(req.getParameter("set").equals("1")){
				req.setAttribute("board", board);
				String[] email = board.getEmail().split("@");
				String email1=email[0];
				String email2=email[1];
				req.setAttribute("email1", email1);
				req.setAttribute("email2", email2);
				BoardContent content =service.findByNum(num);
				req.setAttribute("content", content);
				
				return "/WEB-INF/view/adminpage/free_board_update_form.jsp";
			}else if(req.getParameter("set").equals("2")){
				boardService.deletByNumBoard(board);

				return "free_board.do";
			}
			CommentService commentService = CommentService.getInstance();
			Comment comment = new Comment();
			comment.setBoardNum(board);
			List<Comment> comments =commentService.findByNumComment(comment);
			req.setAttribute("comment", comments);
			
			BoardContent content= service.findByNum(num);
			String con = content.getContent().replace("\r\n", "<br>");
			content.setContent(con);
			req.setAttribute("content", content);
			req.setAttribute("board", board);
			return "/WEB-INF/view/adminpage/boardContent.jsp";
		
		}else if(req.getMethod().equalsIgnoreCase("post")){
			BoardContent boardContent =service.findByNum(num);
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String name = req.getParameter("name");
			String email = req.getParameter("email1")+"@"+req.getParameter("email2");
			String tell = req.getParameter("tell");
			board.setName(name);
			board.setTitle(title);
			board.setEmail(email);
			board.setTel(tell);
			boardContent.setContent(content);
			service.update(board, boardContent);
			
			res.sendRedirect(req.getContextPath()+"/board/content.do?set=4&no="+num);
			
			return null;
		}
		
		return null;
	}
}
