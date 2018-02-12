package Project_JSP.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Event;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.EventContentService;
import Project_JSP.service.EventService;

public class EventDeleteHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/event/";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		
		EventService service = EventService.getInstance();
		EventContentService contentService = EventContentService.getInstance();
		
		String uploadPath = req.getRealPath("/img/event/upload");
		Event event = service.readEventByNum(new Event(no));
		String bannerImg = event.getEventImgPath();
		bannerImg = bannerImg.substring(bannerImg.lastIndexOf("/")+1);
		
		System.out.println("배너 이미지 : " + bannerImg);
		
		//배너 이미지 삭제
		FileUtils.deleteFile(bannerImg, uploadPath);
		
		EventContent oldContent=  contentService.selectEventContentByNum(new EventContent(no));
		
		//content에 있는 이미지파일 삭제
		oldImageDelte(uploadPath, oldContent.getEventContent(), req.getContextPath()+"/img/event/upload");
		
		service.deleteEvent(new Event(no));
		
		res.sendRedirect(req.getContextPath() + "/event/eventlist.do");
		return null;
	}
	
	// uploadPath : 실제 서버저장 경로  | oldContent : 삭제할 내용 | contextPath : split 하기 위한 이미지 경로
	private void oldImageDelte(String uploadPath, String oldContent,String contextPath) {
		
		String oldCotentArr[] = oldContent.split(contextPath);
		
		List<String> oldImage = new ArrayList<>();
		
		for(String src : oldCotentArr){
			int lastIndex = src.indexOf("style");
			
			if(lastIndex > 0){
				System.out.println("delContent : " + src.substring(1,lastIndex-2) );
				oldImage.add(src.substring(1,lastIndex-2).trim());
			}	
		}
		
		for(String img : oldImage){
			FileUtils.deleteFile(img,uploadPath);
		}
	}
}
