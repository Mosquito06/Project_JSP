package Project_JSP.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.Activity;
import Project_JSP.dto.ActivityContent;
import Project_JSP.dto.Event;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.ActivityService;
import Project_JSP.service.EventService;

public class ActivityWriteHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return filePath + "adminpage_activityWrite.jsp"; 
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			ActivityService service =ActivityService.getInstance();
			
			int result = service.selectLastNum()+1;
			
			return postProcess(req, res,"/img/activity/"+ result);
		}
		return null;
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
			
			MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

			HashMap<String, String> map = new HashMap<>();
			
			contextPath = req.getContextPath() + fileUploadPath;
			
			fileName = multi.getFilesystemName("imgBannerPath");
			originFileName = multi.getOriginalFileName("imgBannerPath");
			
			map.put("fileName", fileName);
			map.put("orignFileName", originFileName);
			
			String title = multi.getParameter("title");
			String content = multi.getParameter("hiddenContent");
			String introduce = multi.getParameter("introduce");
			String type =  multi.getParameter("type");
			HttpSession session = req.getSession();
			List<String> fileList =  (List<String>) session.getAttribute("fileList");
			
			if(fileList != null){
				System.out.println("파일 리스트 존재");
				for(String img : fileList){
					if(!content.contains(img)){
						System.out.println("이미지 파일 없음"+img);
						FileUtils.deleteFile(img,uploadPath);
					}
				}
				session.setAttribute("fileList", null);
			}
			
			ActivityService service =ActivityService.getInstance();

			Activity activity = new Activity(); 
			activity.setName(title); 
			activity.setImgPath(contextPath + "/" + fileName);
			activity.setIntroduce(introduce);
			activity.setType(type); 
			ActivityContent content2 = new ActivityContent();
			content2.setContent(content);
			content2.setImgPath(contextPath);
			
			int result = service.insert(activity, content2);

			if (result < 0) {
				req.setAttribute("error", "글쓰기에 실패하였습니다.");
				res.sendRedirect(filePath + "eventWrite.jsp");
				return null; 
			}

			res.sendRedirect(req.getContextPath() + "/adminActivityList.do");
			return null;

		} catch (Exception e) { 
			e.printStackTrace();
			return "";
		}

	}
}
 