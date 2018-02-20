package Project_JSP.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
			postProcess(req, res);
			
			
			res.sendRedirect("free_board.do");
			return null;
		}
		return null;
	}
	
private String postProcess(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Date date = new Date();
		SimpleDateFormat dfY  = new SimpleDateFormat("yyyy");
		String fileDateY = dfY.format(date);
		SimpleDateFormat dfM  = new SimpleDateFormat("MM");
		String fileDateM = dfM.format(date);
		SimpleDateFormat dfD  = new SimpleDateFormat("dd");
		String fileDateD = dfD.format(date);
		
		String uploadPath = req.getRealPath("Qna/"+fileDateY+"/"+fileDateM+"/"+fileDateD);
		
	
		File dir = new File(uploadPath); 
		if(dir.exists() ==false){
			dir.mkdirs();//폴더가 존재하지 않으면 새로 생성해라
		}
		System.out.println("uploadPath = "+uploadPath);
	
		int maxSize = 1024 * 1024 * 10;
		String filename1 = "";
	
		try{
		
			MultipartRequest multi =  new MultipartRequest(req, uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
		
			filename1 = multi.getFilesystemName("filePath");//실제 업로드된 파일명
			if(filename1==null){
				filename1 = "0";
			}else{
				filename1=req.getContextPath()+"/Qna/"+fileDateY+"/"+fileDateM+"/"+fileDateD+"/"+filename1;
			}
			String email = multi.getParameter("email1")+"@"+multi.getParameter("email2");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			String name = multi.getParameter("name");
			
			String tel = multi.getParameter("tel");
			String id = multi.getParameter("memberId");
			Board board = new Board(name, email, tel, title, date, 0,filename1 , id);
				
					
			BoardContent content2 =new BoardContent(board, content);
			BoardService service = BoardService.getInstance();
			service.insertBoard(board, content2);
			String memberId= multi.getParameter("memberId");
			req.setAttribute("memberId", memberId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
