package Project_JSP.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class ActivityModifyHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			int no = Integer.parseInt(req.getParameter("no"));
			ActivityService service = ActivityService.getInstance();
			
			Map<String,Object> list = service.selectContentByNum(new Activity(no));
			Activity activity = (Activity) list.get("activity");
			ActivityContent content = (ActivityContent) list.get("content"); 
			
			String imgPath = req.getRealPath("/img/activity/" + activity.getNum());

			File path = new File(imgPath); 
			System.out.println(path.getName());
			File[] files = path.listFiles();
			
			List<String> fileNames = new ArrayList<>();
			String contextPath = req.getContextPath()+"/img/activity/" + activity.getNum()+"/";
			for(File file : files){
				fileNames.add(contextPath+file.getName());
			}  
			
			req.setAttribute("activity", activity);   
			req.setAttribute("content", content);
			req.setAttribute("fileNames", fileNames);
			
			return filePath + "adminpage_activityModify.jsp";	
		}else if(req.getMethod().equalsIgnoreCase("post")){	
			HttpSession session =  req.getSession();
			int actNo = (int) session.getAttribute("actNo");
			return postProcess(req, res,"/img/activity/"+actNo);
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
			
			MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			HashMap<String, String> map = new HashMap<>();
			
			contextPath = req.getContextPath() + fileUploadPath;
			
			fileName = multi.getFilesystemName("imgBannerPath");
			originFileName = multi.getOriginalFileName("imgBannerPath");
			
			map.put("fileName", fileName);
			map.put("orignFileName", originFileName);
			
			String title = multi.getParameter("title");
			int no = Integer.parseInt(multi.getParameter("no"));
			String content = multi.getParameter("hiddenContent");
			String introduce = multi.getParameter("introduce");
			String type =  multi.getParameter("type");
			String oldBanner = multi.getParameter("oldBanner");
			String oldContent = multi.getParameter("oldContent");
			
			//content = content.substring(content.indexOf("<div>")+5, content.lastIndexOf("</div>"));
			
			HttpSession session = req.getSession();
			List<String> fileList =  (List<String>) session.getAttribute("fileList");
			
			oldImageDelte(uploadPath,content,oldContent,contextPath);
			
			if(fileList != null){ 
				System.out.println("파일 리스트 존재");
				for(String img : fileList){
					if(!content.contains(img)){
						System.out.println("이미지 파일 없음"+img); 
						FileUtils.deleteFile(img,uploadPath);
					}
				}
				fileList = null;
			}
			
			ActivityService service =ActivityService.getInstance();

			Activity activity = new Activity(); 
			activity.setNum(no);
			activity.setName(title); 			
			activity.setIntroduce(introduce);
			activity.setType(type); 
			ActivityContent content2 = new ActivityContent();
			content2.setContent(content);
			content2.setNum(no);
			
			if(fileName != null){
				activity.setImgPath(contextPath + "/" + fileName);
				String[] oldFileName = oldBanner.split("/");
				FileUtils.deleteFile(oldFileName[oldFileName.length-1], uploadPath);
			}else{
				activity.setImgPath(oldBanner);
			}
			
			 
			int result = service.update(activity, content2);
			System.out.println(result);
			if (result < 0) {
				req.setAttribute("error", "수정에 실패하였습니다.");
				res.sendRedirect(req.getContextPath() + "/adminActivityModify.do?no="+no);
				return null;
			}
			
			res.sendRedirect(req.getContextPath() + "/adminActivityList.do");
			return null;
		} catch (Exception e) { 
			e.printStackTrace();
			return null;
		} 
	}

	private void oldImageDelte(String uploadPath, String content, String oldContent,String contextPath) {
		// uploadPath : 실제 서버저장 경로  | content : 새로운 내용 | oldContent : 삭제할 내용 | contextPath : split 하기 위한 이미지 경로
		
		String oldCotentArr[] = oldContent.split(contextPath);
		
		List<String> oldImage = new ArrayList<>();
		
		for(String src : oldCotentArr){
			int lastIndex = src.indexOf("style"); 
			
			if(lastIndex > 0){
				System.out.println("oldContent : " + src.substring(1,lastIndex-2) );
				oldImage.add(src.substring(1,lastIndex-2).trim());
			}	
		}
		   
		for(String img : oldImage){
			if(!content.contains(img)){
				System.out.println("예전 이미지 : "+img);
				FileUtils.deleteFile(img,uploadPath);
			}
		}
	}
}
