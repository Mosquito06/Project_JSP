package Project_JSP.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.Event;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.EventContentService;
import Project_JSP.service.EventService;

public class EventModifyHandler implements CommandHandler {

	private static final String filePath = "/WEB-INF/view/event/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			int no = Integer.parseInt(req.getParameter("no"));
			EventService service = EventService.getInstance();
			EventContentService serviceContent = EventContentService.getInstance();
			Event event = service.readEventByNum(new Event(no));
			EventContent content =serviceContent.selectEventContentByNum(new EventContent(no));
			
			req.setAttribute("event",event);
			req.setAttribute("content", content);
			
			return filePath + "eventModify.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return postProcess(req, res,"/img/event/upload");
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
			
			fileName = multi.getFilesystemName("imgpath");
			originFileName = multi.getOriginalFileName("imgpath");
			
			map.put("fileName", fileName);
			map.put("orignFileName", originFileName);
			
			String title = multi.getParameter("title");
			int no = Integer.parseInt(multi.getParameter("no"));
			String startDate = multi.getParameter("startDate");
			String endDate = multi.getParameter("endDate");
			String content = multi.getParameter("hiddenContent");
			String introduce = multi.getParameter("introduce");
			String oldBanner = multi.getParameter("oldBanner");
			String oldContent = multi.getParameter("oldContent");
			
			content = content.substring(content.indexOf("<div>")+5, content.lastIndexOf("</div>"));
			
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
			
			EventService service = EventService.getInstance();

			Event event = new Event();
			event.setEventNum(no);
			event.setEventTitle(title);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			event.setEventStartDay(format.parse(startDate));
			event.setEventEndDay(format.parse(endDate));
			event.setEventIntroduce(introduce);
			
			if(fileName != null){
				event.setEventImgPath(contextPath + "/" + fileName);
				String[] oldFileName = oldBanner.split("/");
				FileUtils.deleteFile(oldFileName[oldFileName.length-1], uploadPath);
			}else{
				event.setEventImgPath(oldBanner);
			}
			
			
			int result = service.updateEvent(event, content);
			
			if (result < 0) {
				req.setAttribute("error", "수정에 실패하였습니다.");
				res.sendRedirect(filePath + "eventWrite.jsp");
				return null;
			}

			res.sendRedirect(req.getContextPath() + "/event/eventlist.do");
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
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
