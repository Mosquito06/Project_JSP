package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileManagementUtil;

public class EventFileDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String uploadPath = req.getRealPath("/img/event");
		
		HttpSession session = req.getSession();
		List<String> fileList =  (List<String>) session.getAttribute("fileList");
		System.out.println("파일 삭제 로드");
		if(fileList != null){
			System.out.println("파일 리스트 존재");
			for(String img : fileList){		
				System.out.println("이미지 파일 없음"+img);
				FileManagementUtil.deleteFile(img,uploadPath);
			}
			session.setAttribute("fileList", null);
		}
		
		res.sendRedirect(req.getContextPath() + "/event/eventlist.do");
		return null;
	}

}
