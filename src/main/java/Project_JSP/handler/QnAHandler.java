package Project_JSP.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.ClientGrade;
import Project_JSP.dto.QnaBoard;
import Project_JSP.dto.QnaBoardContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.QnaBoardContentService;
import Project_JSP.service.QnaBoardService;

public class QnAHandler implements CommandHandler{
	private static final String QNA_VIEW = "/WEB-INF/view/qna/qna_form.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return QNA_VIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
	
			postProcess(req,res);
			res.sendRedirect("qnaRegister.do");
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
			
			String email = multi.getParameter("email1")+"@"+multi.getParameter("email2");
			QnaBoard qnaBoard = new QnaBoard();
			qnaBoard.setTitle(multi.getParameter("title"));
			qnaBoard.setName(multi.getParameter("name"));
			qnaBoard.setEmail(email);
		
			qnaBoard.setPath("Qna/"+fileDateY+"/"+fileDateM+"/"+fileDateD+"/"+filename1);
			
			qnaBoard.setTel(multi.getParameter("tel"));
			qnaBoard.setDate(new Date());
			
			if(req.getSession().getAttribute("MEMBER") !=null){
				qnaBoard.setClientGrade(ClientGrade.MEMBER);
			}else{
				qnaBoard.setClientGrade(ClientGrade.NONMEMBER);
			}
			
			QnaBoardService service = QnaBoardService.getInstance();
			service.insertQnaBoard(qnaBoard);
			
			int num = service.lastId();
			String content = multi.getParameter("content");
			
			QnaBoardContent qnaContent = new QnaBoardContent(num, content);
			QnaBoardContentService service2 = QnaBoardContentService.getInstance();
			service2.insertQnaBoardContent(qnaContent);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
