package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Gallery;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.GalleryDaoService;

public class AdminGalleryListHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		GalleryDaoService service = GalleryDaoService.getInstance();

		if(req.getMethod().equalsIgnoreCase("get")){
			
			List<Gallery> list = service.selectGallery();
			
			if(list ==null){
				req.setAttribute("error", "추가된 갤러리 이미지가 없습니다.");
			}else{
				req.setAttribute("list", list);
				System.out.println("핸들러 : "+list);
			}
			
			return filePath + "adminpage_gallery_list.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			ObjectMapper om = new ObjectMapper(); 	
			 
			String no =req.getParameter("no"); 
			String img =req.getParameter("img"); 
			
			int result = service.deleteGallery(new Gallery(Integer.parseInt(no)));

			String uploadPath = req.getRealPath("/img/gallary");
			FileUtils.deleteFile(img, uploadPath);
			
			HashMap<String, Object> sendData = new HashMap<>();
			
			sendData.put("result", result);
			
			String json = om.writeValueAsString(sendData);
			res.setContentType("application/json;charset=utf-8");
			
			PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성
			pw.print(json); //json pw에 넣기
			pw.flush(); //내보내기 
			
			return null; 
		}
		 
		return null;
	}

}
