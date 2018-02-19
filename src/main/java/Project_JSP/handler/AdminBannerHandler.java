package Project_JSP.handler;


import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.Banner;
import Project_JSP.dto.Event;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.BannerService;
import Project_JSP.service.EventService;

public class AdminBannerHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String set = req.getParameter("set");
			BannerService service = BannerService.getInstance();
			
			List<Banner> list = service.select();
			
			req.setAttribute("list", list);
			return filePath+"adminpage_banner.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String set = req.getParameter("set");
			BannerService service = BannerService.getInstance(); 
			
			if(set.equals("delete")){
				ObjectMapper om = new ObjectMapper(); 	
				
				String no = req.getParameter("no");
				Banner banner = service.selectByNo(new Banner(Integer.parseInt(no)));
				int result = service.delete(new Banner(Integer.parseInt(no)));
				String[] imgPath = banner.getImgPath().split("/");
				String uploadPath = req.getRealPath("/img/admin/upload");
				FileUtils.deleteFile(imgPath[imgPath.length-1], uploadPath);
				HashMap<String, Object> sendData = new HashMap<>();
				
				sendData.put("result", result);
				
				String json = om.writeValueAsString(sendData);
				res.setContentType("application/json;charset=utf-8");
				
                //PrintWrit == out과 같다.
				PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성
				pw.print(json); //json pw에 넣기
				pw.flush(); //내보내기 
				
				return null;
			}  
			
			if(set.equals("insert")){
				postProcess(req,res,"/img/admin/upload");
				res.sendRedirect(req.getContextPath()+"/adminBanner.do");
				return null; 
			} 
			return filePath+"adminpage_banner.jsp";
		}
		return filePath+"adminpage_banner.jsp";
	}
	
	private String postProcess(HttpServletRequest req, HttpServletResponse res,String fileUploadPath) {
		String uploadPath = req.getRealPath(fileUploadPath);
		String contextPath = "";
		
		File dir = new File(uploadPath);
		if (dir.exists() == false) {
			dir.mkdirs();// 폴더만들기
		}
		
		System.out.println("uploadPath - " + uploadPath); 

		int maxSize = 1024 * 1024 * 10;// 10M
		String fileName = "";
		String originFileName = "";
		try {
			BannerService service = BannerService.getInstance();
			
			MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			HashMap<String, String> map = new HashMap<>();
			
			contextPath = req.getContextPath() + fileUploadPath;
			
			String linkPath = multi.getParameter("linkPath");
			
			fileName = multi.getFilesystemName("imgPath");
			originFileName = multi.getOriginalFileName("imgPath");
			 
			String imgPath = contextPath + "/" + fileName;
			int result = service.insert(new Banner(0, linkPath, imgPath));
			
			HashMap<String, Object> sendData = new HashMap<>(); 
			if(result<0){
				sendData.put("error", "추가에 실패하였습니다.");
				return null; 
			}
			
			int lastNo = service.getLastInsert();
			
			return  null;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	
}
  